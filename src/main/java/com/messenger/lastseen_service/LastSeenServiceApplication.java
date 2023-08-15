package com.messenger.lastseen_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class LastSeenServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LastSeenServiceApplication.class, args);
    }

}
