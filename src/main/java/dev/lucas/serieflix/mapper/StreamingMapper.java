package dev.lucas.serieflix.mapper;

import dev.lucas.serieflix.controller.request.StreamingRequest;
import dev.lucas.serieflix.controller.response.StreamingResponse;
import dev.lucas.serieflix.model.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request){
        return Streaming
                .builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }

    public static Streaming prepareToUpdate(Streaming streaming, StreamingRequest request){
        if (request == null || streaming == null) {
            return streaming;
        }
        if(request.name() != null){
            streaming.setName(request.name());
        }
        return streaming;
    }
}
