package dev.aachal.kanbanwebapp.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "SUBTASK_TABLE")
public record Subtask(
        @Id
        @Column(value = "ID")
        Integer id,
        @NotBlank
        @Column(value = "TITLE")
        String title,
        @Column(value = "COMPLETED")
        boolean completed,
        @Column(value = "TASK_ID")
        Integer task
) {
}
