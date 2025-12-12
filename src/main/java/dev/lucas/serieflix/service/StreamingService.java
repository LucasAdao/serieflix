package dev.lucas.serieflix.service;

import dev.lucas.serieflix.controller.request.StreamingRequest;
import dev.lucas.serieflix.controller.response.StreamingResponse;
import dev.lucas.serieflix.exceptions.streaming.StreamingNotFoundException;
import dev.lucas.serieflix.exceptions.streaming.StreamingNotNullException;
import dev.lucas.serieflix.mapper.StreamingMapper;
import dev.lucas.serieflix.model.Streaming;
import dev.lucas.serieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository repository;

    public StreamingResponse findById(Long id) {
        Optional<Streaming> streaming = repository.findById(id);
        return streaming.map(StreamingMapper::toStreamingResponse).orElseThrow(() -> new StreamingNotFoundException(id));

    }

    public List<StreamingResponse> findAll() {
        List<Streaming> streamings = repository.findAll();
        return streamings.stream()
                .map(StreamingMapper::toStreamingResponse)
                .collect(Collectors.toList());
    }

    public StreamingResponse save(StreamingRequest request) {
        if(request == null) {
            throw new StreamingNotNullException();
        }
        Streaming streaming = StreamingMapper.toStreaming(request);
        streaming = repository.save(streaming);
        return StreamingMapper.toStreamingResponse(streaming);
    }

    public void deleteById(Long id) {
        repository.findById(id).orElseThrow(() -> new StreamingNotFoundException(id));
        repository.deleteById(id);
    }

    public StreamingResponse updateById(Long id, StreamingRequest request) {
        Streaming streaming = repository.findById(id).orElseThrow(() -> new StreamingNotFoundException(id));
        Streaming streamingToSave = StreamingMapper.prepareToUpdate(streaming,request);
        repository.save(streamingToSave);
        return StreamingMapper.toStreamingResponse(streamingToSave);
    }

}
