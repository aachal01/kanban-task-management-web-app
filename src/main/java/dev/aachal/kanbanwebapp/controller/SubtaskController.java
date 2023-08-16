package dev.aachal.kanbanwebapp.controller;

import dev.aachal.kanbanwebapp.model.Subtask;
import dev.aachal.kanbanwebapp.repository.contentCollectionRepository.SubtaskCollectionRepository;
import dev.aachal.kanbanwebapp.repository.contentRepository.SubtaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/subtask")
public class SubtaskController {

//    private final SubtaskCollectionRepository repository;
private final SubtaskRepository repository;


    @Autowired
    public SubtaskController(SubtaskRepository repository) {
        this.repository = repository;
    }

    //Read All
    @GetMapping("")
    public List<Subtask> findAllSubtasks() {
        return repository.findAll();
    }


    //Read by ID
    @GetMapping("/{id}")
    public Subtask findSubtaskById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }

    //Create new subtasks
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createSubtask(@Valid @RequestBody Subtask subtask){
        repository.save(subtask);
    }

    //Update existing subtasks
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateSubtask(@RequestBody Subtask subtask, @PathVariable
    Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.save(subtask);
    }

    //Delete the subtask
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteSubtask(@PathVariable Integer id){
        repository.deleteById(id);
    }

}
