package com.rentacarcqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.rentacarcqrs",
"io.github.mhmmedinan.core_localization","io.github.mhmmedinan.core_persistence","io.github.mhmmedinan.core_crosscuttingconcerns"})
public class RentACarCqrsApplication {

public static void main(String[] args) {
    SpringApplication.run(RentACarCqrsApplication.class, args);
   }
}
