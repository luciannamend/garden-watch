package com.lucianna.gardensimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GardenSimulatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GardenSimulatorApplication.class, args);
    }

}
