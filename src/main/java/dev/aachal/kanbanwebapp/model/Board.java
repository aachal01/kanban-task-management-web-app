package dev.aachal.kanbanwebapp.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table(value = "board_table")
public record Board(
        @Id
        Integer id,
        @NotBlank
        String title,
        List<Column> columns
) {
}
