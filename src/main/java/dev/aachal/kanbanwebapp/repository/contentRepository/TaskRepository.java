package dev.aachal.kanbanwebapp.repository.contentRepository;

import dev.aachal.kanbanwebapp.model.Task;
import org.springframework.data.repository.ListCrudRepository;

public interface TaskRepository extends ListCrudRepository<Task, Integer> {
}
