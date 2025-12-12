package dev.lucas.serieflix.controller.response;

import lombok.Builder;

@Builder
public record StreamingResponse(long id,
                                String name) {
}
