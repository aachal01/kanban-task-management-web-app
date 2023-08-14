package dev.aachal.kanbanwebapp.controller;

import dev.aachal.kanbanwebapp.model.Subtask;
import dev.aachal.kanbanwebapp.repository.SubtaskCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/subtask")
public class SubtaskController {

    private final SubtaskCollectionRepository repository;


    @Autowired
    public SubtaskController(SubtaskCollectionRepository repository) {
        this.repository = repository;
    }

    //Read All
    @GetMapping("")
    public List<Subtask> findAllSubtasks() {
        return repository.findAllSubtasks();
    }


    //Read by ID
    @GetMapping("/{id}")
    public Subtask findSubtaskById(@PathVariable Integer id) {
        return repository.findSubtaskById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }

    //Create new subtasks
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createSubtask(@Valid @RequestBody Subtask subtask){
        repository.saveSubtask(subtask);
    }

    //Update existing subtasks
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateSubtask(@RequestBody Subtask subtask, @PathVariable
    Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.saveSubtask(subtask);
    }

    //Delete the subtask
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteSubtask(@PathVariable Integer id){
        repository.deleteSubtask(id);
    }

}
