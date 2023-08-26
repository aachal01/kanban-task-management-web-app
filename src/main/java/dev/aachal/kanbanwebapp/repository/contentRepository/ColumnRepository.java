package dev.aachal.kanbanwebapp.repository.contentRepository;

import dev.aachal.kanbanwebapp.model.BoardColumn;
import org.springframework.data.repository.ListCrudRepository;

public interface ColumnRepository extends ListCrudRepository<BoardColumn, Integer> {
}
