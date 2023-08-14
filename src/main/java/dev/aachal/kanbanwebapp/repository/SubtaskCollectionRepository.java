package dev.aachal.kanbanwebapp.repository;


import dev.aachal.kanbanwebapp.model.Subtask;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SubtaskCollectionRepository {

    private final List<Subtask> subtaskList = new ArrayList<>();

    public SubtaskCollectionRepository(){
    }


    //Read All
    public List<Subtask> findAllSubtasks(){
        return subtaskList;
    }

    public Optional<Subtask> findSubtaskById(Integer id){
        return subtaskList.stream().filter(b->b.id().equals(id)).findFirst();
    }

    public void saveSubtask(Subtask subtask) {
        subtaskList.removeIf(c -> c.id().equals(subtask.id()));
        subtaskList.add(subtask);
    }

    public boolean existsById(Integer id) {
        return subtaskList.stream().filter(b->b.id().equals(id)).count() == 1;
    }

    public void deleteSubtask(Integer id) {
        subtaskList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void init(){
        Subtask subtask = new Subtask(
                1,
                "Subtask 1",
                true
        );

        subtaskList.add(subtask);
    }
}
