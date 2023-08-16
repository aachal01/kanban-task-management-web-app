package dev.aachal.kanbanwebapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.scheduling.config.Task;
import jakarta.validation.constraints.NotBlank;


import java.util.List;

@Table(value = "column_table")
public record Column(
        @Id
        Integer id,
        @NotBlank
        String title,
        List<Task> tasks
) {
}
