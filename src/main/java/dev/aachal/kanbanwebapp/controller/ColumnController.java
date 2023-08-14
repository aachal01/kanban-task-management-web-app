package dev.aachal.kanbanwebapp.controller;

import dev.aachal.kanbanwebapp.model.Column;
import dev.aachal.kanbanwebapp.repository.ColumnCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/column")
public class ColumnController {

    private final ColumnCollectionRepository repository;


    @Autowired
    public ColumnController(ColumnCollectionRepository repository) {
        this.repository = repository;
    }

    //Read All
    @GetMapping("")
    public List<Column> findAllColumn() {
        return repository.findAllColumns();
    }


    //Read by ID
    @GetMapping("/{id}")
    public Column findColumnById(@PathVariable Integer id) {
        return repository.findColumnById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }

    //Create new Columns
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createColumn(@Valid @RequestBody Column column){
        repository.saveColumn(column);
    }

    //Update existing Columns
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateColumn(@RequestBody Column column, @PathVariable
    Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.saveColumn(column);
    }

    //Delete the Column
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteColumn(@PathVariable Integer id){
        repository.deleteColumn(id);
    }
}
