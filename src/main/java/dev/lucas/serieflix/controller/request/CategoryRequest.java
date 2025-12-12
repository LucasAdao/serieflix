package dev.lucas.serieflix.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(@NotBlank(message = "The category name can't be null!")
                              @Size(min = 3, max = 100, message = "The name must be between {min} and {max} characters.")
                              String name) {
}
