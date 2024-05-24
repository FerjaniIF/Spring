package com.rental.car_demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(nullable = false)
    private LocalDateTime pickupDateTime;

    @Column(nullable = false)
    private LocalDateTime dropoffDateTime;

    @Column(nullable = false)
    private String pickupLocation;

    @Column(nullable = false)
    private String dropoffLocation;

    @Column(nullable = false)
    private Double totalPrice;

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Car getCar() {
		return car;
	}

	public LocalDateTime getPickupDateTime() {
		return pickupDateTime;
	}

	public LocalDateTime getDropoffDateTime() {
		return dropoffDateTime;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public String getDropoffLocation() {
		return dropoffLocation;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setPickupDateTime(LocalDateTime pickupDateTime) {
		this.pickupDateTime = pickupDateTime;
	}

	public void setDropoffDateTime(LocalDateTime dropoffDateTime) {
		this.dropoffDateTime = dropoffDateTime;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public void setDropoffLocation(String dropoffLocation) {
		this.dropoffLocation = dropoffLocation;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

    
}
