package com.project.autodealz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AutoDealzApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoDealzApplication.class, args);
    }

}
