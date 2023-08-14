package dev.aachal.kanbanwebapp.model;

import org.springframework.scheduling.config.Task;
import jakarta.validation.constraints.NotBlank;


import java.util.List;

public record Column(
        Integer id,
        @NotBlank
        String title,
        List<Task> tasks
) {
}
