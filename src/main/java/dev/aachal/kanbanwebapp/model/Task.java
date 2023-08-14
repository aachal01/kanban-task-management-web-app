package dev.aachal.kanbanwebapp.model;

import java.util.List;
import jakarta.validation.constraints.NotBlank;


public record Task(
        Integer id,

        @NotBlank
        String title,
        String desc,
        @NotBlank
        String currentColumn,
        List<Subtask>subtasks
) {
}
