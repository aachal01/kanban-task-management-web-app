package dev.aachal.kanbanwebapp.model;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;


public record Task(
        @Id
        Integer id,
        @NotBlank
        String title,
        String desc,
        @NotBlank
        String currentColumn,
        List<Subtask>subtasks
) {
}
