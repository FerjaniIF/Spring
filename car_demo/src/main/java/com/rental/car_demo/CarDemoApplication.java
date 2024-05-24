package com.rental.car_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rental.car_demo")
public class CarDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarDemoApplication.class, args);
    }
}
