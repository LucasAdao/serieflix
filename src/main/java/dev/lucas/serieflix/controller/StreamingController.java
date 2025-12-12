package dev.lucas.serieflix.controller;

import dev.lucas.serieflix.controller.request.StreamingRequest;
import dev.lucas.serieflix.controller.response.StreamingResponse;
import dev.lucas.serieflix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> findAll(){
        return ResponseEntity.ok(streamingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(streamingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> save(@RequestBody StreamingRequest request){
        StreamingResponse save = streamingService.save(request);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        streamingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StreamingResponse> update(@PathVariable Long id, @RequestBody StreamingRequest request){
        StreamingResponse streamingResponse = streamingService.updateById(id, request);
        return ResponseEntity.ok(streamingResponse);
    }

}
