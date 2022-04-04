package com.titxu.storage;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.titxu.storage", "com.titxu.base", "com.titxu.common"})
public class ApplicationStorage {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStorage.class, args);
    }
}

