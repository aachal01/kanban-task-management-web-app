package dev.aachal.kanbanwebapp.repository.contentCollectionRepository;

import dev.aachal.kanbanwebapp.model.Board;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BoardCollectionRepository {

    private final List<Board> boardList = new ArrayList<>();

    public BoardCollectionRepository(){
    }


    //Read All
    public List<Board> findAllBoards(){
        return boardList;
    }

    public Optional<Board> findBoardById(Integer id){
        return boardList.stream().filter(b->b.id().equals(id)).findFirst();
    }

    public void saveBoard(Board board) {
        boardList.removeIf(c -> c.id().equals(board.id()));
        boardList.add(board);
    }

    public boolean existsById(Integer id) {
        return boardList.stream().filter(b->b.id().equals(id)).count() == 1;
    }

    public void deleteBoard(Integer id) {
        boardList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void init(){
        Board board = new Board(
                1,
                "Platform Launch",
                new ArrayList<>()
        );

        boardList.add(board);
    }


}
