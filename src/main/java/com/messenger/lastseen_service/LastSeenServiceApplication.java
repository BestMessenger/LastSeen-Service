package com.messenger.lastseen_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "LastSeen API",version = "1.0",description = "Documentation LastSeen API v1.0"))
@EnableDiscoveryClient
public class LastSeenServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LastSeenServiceApplication.class, args);
    }

}
