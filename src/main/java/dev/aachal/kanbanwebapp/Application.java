package dev.aachal.kanbanwebapp;

import dev.aachal.kanbanwebapp.model.Board;
import dev.aachal.kanbanwebapp.repository.contentRepository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BoardRepository repository){
		return args -> {
			Board board = new Board(
					null,
					"Platform Launch"
			);
			repository.save(board);
		};
	}

}
