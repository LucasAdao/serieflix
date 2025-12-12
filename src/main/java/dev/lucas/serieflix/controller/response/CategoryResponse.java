package dev.lucas.serieflix.controller.response;

import lombok.Builder;

@Builder
public record CategoryResponse(long id,
                               String name) {
}
