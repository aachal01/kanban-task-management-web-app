package dev.aachal.kanbanwebapp.controller;


import dev.aachal.kanbanwebapp.model.Board;
import dev.aachal.kanbanwebapp.repository.contentCollectionRepository.BoardCollectionRepository;
import dev.aachal.kanbanwebapp.repository.contentRepository.BoardRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

//    private final BoardCollectionRepository repository;
private final BoardRepository repository;

    @Autowired
    public BoardController(BoardRepository repository) {
        this.repository = repository;
    }

    //Read All
    @GetMapping("")
    public List<Board> findAllBoards() {
        return repository.findAll();
    }


    //Read by ID
    @GetMapping("/{id}")
    public Board findBoardById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }

    //Create new boards
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createBoard(@Valid @RequestBody Board board){
        repository.save(board);
    }

    //Update existing boards
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateBoard(@RequestBody Board board, @PathVariable
    Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.save(board);
    }

    //Delete the board
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Integer id){
        repository.deleteById(id);
    }

}
