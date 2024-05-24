package com.rental.car_demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RentalRequest {
    private Long userId;
    private Long carId;
    private LocalDateTime pickupDateTime;
    private LocalDateTime dropoffDateTime;
    private String pickupLocation;
    private String dropoffLocation;
	public Long getUserId() {
		return userId;
	}
	public Long getCarId() {
		return carId;
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
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
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
    
    
}
