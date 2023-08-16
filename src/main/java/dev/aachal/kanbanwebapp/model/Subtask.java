package dev.aachal.kanbanwebapp.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;


public record Subtask(
        @Id
        Integer id,
        @NotBlank
        String title,
        boolean completed
) {
}
