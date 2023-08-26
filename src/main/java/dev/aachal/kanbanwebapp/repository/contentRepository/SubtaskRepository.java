package dev.aachal.kanbanwebapp.repository.contentRepository;

import dev.aachal.kanbanwebapp.model.Subtask;
import org.springframework.data.repository.ListCrudRepository;

public interface SubtaskRepository extends ListCrudRepository<Subtask, Integer> {
}
