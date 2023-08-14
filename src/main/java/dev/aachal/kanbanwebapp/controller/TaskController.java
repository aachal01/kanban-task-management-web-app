package dev.aachal.kanbanwebapp.controller;


import dev.aachal.kanbanwebapp.model.Task;
import dev.aachal.kanbanwebapp.repository.TaskCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskCollectionRepository repository;


    @Autowired
    public TaskController(TaskCollectionRepository repository) {
        this.repository = repository;
    }

    //Read All
    @GetMapping("")
    public List<Task> findAllTask() {
        return repository.findAllTasks();
    }


    //Read by ID
    @GetMapping("/{id}")
    public Task findTaskById(@PathVariable Integer id) {
        return repository.findTaskById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }

    //Create new tasks
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createTask(@Valid @RequestBody Task task){
        repository.saveTask(task);
    }

    //Update existing tasks
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateTask(@RequestBody Task task, @PathVariable
    Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.saveTask(task);
    }

    //Delete the task
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id){
        repository.deleteTask(id);
    }
}
