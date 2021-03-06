package com.titxu.sms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"com.titxu.sms","com.titxu.base", "com.titxu.common"})
public class ApplicationSms {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationSms.class, args);
    }
}
