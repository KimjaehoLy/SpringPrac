package com.sparta.postco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PostcoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostcoApplication.class, args);
    }

}
