package com.titxu.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component("com.titxu.core")
public class ApplicationCore {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationCore.class, args);
        // try {
        //     SpringApplication.run(ApplicationCore.class, args);
        // }catch (Exception e){
        //     e.printStackTrace();
        // }
    }
}
