package com.rental.car_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rental.car_demo.entity.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
}
