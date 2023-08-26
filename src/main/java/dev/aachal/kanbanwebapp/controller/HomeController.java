package dev.aachal.kanbanwebapp.controller;

import dev.aachal.kanbanwebapp.config.ContentProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    private final ContentProperties properties;

    public HomeController(ContentProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentProperties home(){
        return properties;
    }
}
