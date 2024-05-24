package com.rental.car_demo.controller;

import com.rental.car_demo.dto.RentalRequest;
import com.rental.car_demo.entity.Car;
import com.rental.car_demo.entity.Rental;
import com.rental.car_demo.entity.User;
import com.rental.car_demo.service.CarService;
import com.rental.car_demo.service.RentalService;
import com.rental.car_demo.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import com.rental.car_demo.dto.RentalRequest;


@RestController
@RequestMapping("/api/rentals")
@CrossOrigin("*")
public class RentalController {

    private final RentalService rentalService;
	private  UserService userService;
	private  CarService carService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/rent-car")
    public ResponseEntity<Rental> rentCar(@RequestBody RentalRequest rentalRequest) {
        User user = userService.getUserById(rentalRequest.getUserId());
        Car car = carService.getCarById(rentalRequest.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));


        Rental rental = rentalService.rentCar(user, car, rentalRequest.getPickupDateTime(),
                rentalRequest.getDropoffDateTime(), rentalRequest.getPickupLocation(),
                rentalRequest.getDropoffLocation());

        return new ResponseEntity<>(rental, HttpStatus.CREATED);
    }

}
