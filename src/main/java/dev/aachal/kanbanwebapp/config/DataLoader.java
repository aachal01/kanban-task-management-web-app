package dev.aachal.kanbanwebapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.aachal.kanbanwebapp.model.Board;
import dev.aachal.kanbanwebapp.repository.contentRepository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.type.TypeReference;


import java.io.InputStream;
import java.util.List;

//@Profile("!dev") //set the profile
@Component
public class DataLoader implements CommandLineRunner {


    private final BoardRepository repository;
    private final ObjectMapper objectMapper;
    public DataLoader(BoardRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception{
        if(repository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/BoardData.json")) {
                repository.saveAll(objectMapper.readValue(inputStream,new TypeReference<List<Board>>(){}));
            }
        }
    }
}
