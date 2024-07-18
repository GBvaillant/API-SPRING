package com.example.apidev.dtos;

import jakarta.validation.constraints.NotBlank;

public record PostDto(@NotBlank String title, @NotBlank String description) {
}
