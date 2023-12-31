package dev.aachal.kanbanwebapp;

import dev.aachal.kanbanwebapp.config.ContentProperties;
import dev.aachal.kanbanwebapp.model.Board;
import dev.aachal.kanbanwebapp.repository.contentRepository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ContentProperties.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
