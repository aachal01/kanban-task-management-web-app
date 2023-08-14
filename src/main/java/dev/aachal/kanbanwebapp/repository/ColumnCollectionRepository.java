package dev.aachal.kanbanwebapp.repository;

import dev.aachal.kanbanwebapp.model.Column;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ColumnCollectionRepository {
    private final List<Column> columnList = new ArrayList<>();

    public ColumnCollectionRepository(){
    }


    //Read All
    public List<Column> findAllColumns(){
        return columnList;
    }

    public Optional<Column> findColumnById(Integer id){
        return columnList.stream().filter(b->b.id().equals(id)).findFirst();
    }

    public void saveColumn(Column column) {
        columnList.removeIf(c -> c.id().equals(column.id()));
        columnList.add(column);
    }

    public boolean existsById(Integer id) {
        return columnList.stream().filter(b->b.id().equals(id)).count() == 1;
    }

    public void deleteColumn(Integer id) {
        columnList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void init(){
        Column column = new Column(
                1,
                "ToDo Column",
                new ArrayList<>()
        );

        columnList.add(column);
    }
}
