package com.rental.car_demo.service;

import com.rental.car_demo.entity.Car;
import com.rental.car_demo.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car updateCar(Long id, Car carDetails) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        car.setModel(carDetails.getModel());
        car.setPrice(carDetails.getPrice());
        car.setNumDoors(carDetails.getNumDoors());
        car.setNumSeats(carDetails.getNumSeats());
        car.setFuelType(carDetails.getFuelType());
        car.setCategory(carDetails.getCategory());
        car.setMode(carDetails.getMode());
        car.setDescription(carDetails.getDescription());
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        carRepository.delete(car);
    }
}
