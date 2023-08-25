package dev.aachal.kanbanwebapp.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table(value = "BOARD_TABLE")
public record Board(
        @Id
        @Column(value = "ID")
        Integer id,
        @NotBlank
        @Column(value = "TITLE")
        String title

//        List<Column> columns
) {
}
