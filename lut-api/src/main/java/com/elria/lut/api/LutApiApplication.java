package com.elria.lut.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LutApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(LutApiApplication.class, args);
    }
}
