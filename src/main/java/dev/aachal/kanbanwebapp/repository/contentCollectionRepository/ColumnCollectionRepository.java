package dev.aachal.kanbanwebapp.repository.contentCollectionRepository;

import dev.aachal.kanbanwebapp.model.BoardColumn;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ColumnCollectionRepository {
    private final List<BoardColumn> columnList = new ArrayList<>();

    public ColumnCollectionRepository(){
    }


    //Read All
    public List<BoardColumn> findAllColumns(){
        return columnList;
    }

    public Optional<BoardColumn> findColumnById(Integer id){
        return columnList.stream().filter(b->b.id().equals(id)).findFirst();
    }

    public void saveColumn(BoardColumn column) {
        columnList.removeIf(c -> c.id().equals(column.id()));
        columnList.add(column);
    }

    public boolean existsById(Integer id) {
        return columnList.stream().filter(b->b.id().equals(id)).count() == 1;
    }

    public void deleteColumn(Integer id) {
        columnList.removeIf(c -> c.id().equals(id));
    }

//    @PostConstruct
//    private void init(){
//        BoardColumn column = new BoardColumn(
//                1,
//                "ToDo Column",
//                new ArrayList<>()
//        );
//
//        columnList.add(column);
//    }
}
