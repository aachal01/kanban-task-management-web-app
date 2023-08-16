package dev.aachal.kanbanwebapp.repository.contentCollectionRepository;


import dev.aachal.kanbanwebapp.model.Task;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskCollectionRepository {
    private final List<Task> taskList = new ArrayList<>();

    public TaskCollectionRepository(){
    }


    //Read All
    public List<Task> findAllTasks(){
        return taskList;
    }

    public Optional<Task> findTaskById(Integer id){
        return taskList.stream().filter(b->b.id().equals(id)).findFirst();
    }

    public void saveTask(Task task) {
        taskList.removeIf(c -> c.id().equals(task.id()));
        taskList.add(task);
    }

    public boolean existsById(Integer id) {
        return taskList.stream().filter(b->b.id().equals(id)).count() == 1;
    }

    public void deleteTask(Integer id) {
        taskList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void init(){
        Task task = new Task(
                1,
                "Platform Launch",
                "",
                "",
                new ArrayList<>()
        );

        taskList.add(task);
    }
}
