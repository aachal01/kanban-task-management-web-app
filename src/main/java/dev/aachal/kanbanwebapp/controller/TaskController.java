package dev.aachal.kanbanwebapp.controller;


import dev.aachal.kanbanwebapp.model.Task;
import dev.aachal.kanbanwebapp.repository.contentCollectionRepository.TaskCollectionRepository;
import dev.aachal.kanbanwebapp.repository.contentRepository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/secured/api/task")
public class TaskController {

//    private final TaskCollectionRepository repository;
private final TaskRepository repository;

    @Autowired
    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    //Read All
    @GetMapping("")
    public List<Task> findAllTask() {
        return repository.findAll();
    }


    //Read by ID
    @GetMapping("/{id}")
    public Task findTaskById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }

    //Create new tasks
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createTask(@Valid @RequestBody Task task){
        repository.save(task);
    }

    //Update existing tasks
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateTask(@RequestBody Task task, @PathVariable
    Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.save(task);
    }

    //Delete the task
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
