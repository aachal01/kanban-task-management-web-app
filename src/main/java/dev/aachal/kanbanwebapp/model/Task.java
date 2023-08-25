package dev.aachal.kanbanwebapp.model;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "TASK_TABLE ")
public record Task(
        @Id
        @Column(value = "ID")
        Integer id,
        @NotBlank
        @Column(value = "TITLE")
        String title,
        @Column(value = "DESCRIPTION")
        String desc,
        @NotBlank
        @Column(value = "COLUMN_ID")
        Integer currentColumn
//        List<Subtask>subtasks
) {
}
