package dev.aachal.kanbanwebapp.repository.contentRepository;

import dev.aachal.kanbanwebapp.model.Board;
import org.springframework.data.repository.ListCrudRepository;

public interface BoardRepository extends ListCrudRepository<Board, Integer> {

}
