package dev.aachal.kanbanwebapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.NotBlank;

@Table(value = "COLUMN_TABLE")
public record BoardColumn(
        @Id
        @Column(value = "ID")
        Integer id,
        @NotBlank
        @Column(value = "TITLE")
        String title,
//        List<Task> tasks
        @Column(value = "BOARD_ID")
        Integer board
) {
}
