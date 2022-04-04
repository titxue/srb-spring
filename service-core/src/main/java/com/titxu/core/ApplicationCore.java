package com.titxu.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.titxu.core", "com.titxu.base","com.titxu.common"})
public class ApplicationCore {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationCore.class, args);
    }
}
