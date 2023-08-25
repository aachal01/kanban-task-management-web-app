package dev.aachal.kanbanwebapp.controller;

import dev.aachal.kanbanwebapp.model.BoardColumn;
import dev.aachal.kanbanwebapp.repository.contentRepository.ColumnRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/column")
public class ColumnController {

//    private final ColumnCollectionRepository repository;
private final ColumnRepository repository;


    @Autowired
    public ColumnController(ColumnRepository repository) {
        this.repository = repository;
    }

    //Read All
    @GetMapping("")
    public List<BoardColumn> findAllColumn() {
        return repository.findAll();
    }


    //Read by ID
    @GetMapping("/{id}")
    public BoardColumn findColumnById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }

    //Create new Columns
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createColumn(@Valid @RequestBody BoardColumn column){
        repository.save(column);
    }

    //Update existing Columns
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateColumn(@RequestBody BoardColumn column, @PathVariable
    Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.save(column);
    }

    //Delete the Column
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteColumn(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
