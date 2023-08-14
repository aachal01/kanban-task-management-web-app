package dev.aachal.kanbanwebapp.model;

import jakarta.validation.constraints.NotBlank;


public record Subtask(
        Integer id,
        @NotBlank
        String title,
        boolean completed
) {
}
