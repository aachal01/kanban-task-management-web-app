package dev.aachal.kanbanwebapp.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "app")
public record ContentProperties(String welcomeMessage, String about) {
}
