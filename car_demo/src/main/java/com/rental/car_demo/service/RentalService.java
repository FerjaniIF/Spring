package com.rental.car_demo.service;

import com.rental.car_demo.entity.Car;
import com.rental.car_demo.entity.Rental;
import com.rental.car_demo.entity.User;
import com.rental.car_demo.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public Rental rentCar(User user, Car car, LocalDateTime pickupDateTime, LocalDateTime dropoffDateTime,
                          String pickupLocation, String dropoffLocation) {
        Duration duration = Duration.between(pickupDateTime, dropoffDateTime);
        long hours = duration.toHours();
        Double totalPrice = hours * car.getPrice();

        Rental rental = new Rental();
        rental.setUser(user);
        rental.setCar(car);
        rental.setPickupDateTime(pickupDateTime);
        rental.setDropoffDateTime(dropoffDateTime);
        rental.setPickupLocation(pickupLocation);
        rental.setDropoffLocation(dropoffLocation);
        rental.setTotalPrice(totalPrice);

        return rentalRepository.save(rental);
    }

}
