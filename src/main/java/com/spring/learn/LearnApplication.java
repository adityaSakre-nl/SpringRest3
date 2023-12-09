package com.spring.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LearnApplication {

    @GetMapping("/")
    public String home(){
        return "Hello, User";
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

}
