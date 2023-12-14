package com.example.demo.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Command line runner...");
        };
    }
}
