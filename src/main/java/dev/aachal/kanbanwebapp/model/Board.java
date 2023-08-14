package dev.aachal.kanbanwebapp.model;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record Board(

        Integer id,
        @NotBlank
        String title,
        List<Column> columns
) {
}
