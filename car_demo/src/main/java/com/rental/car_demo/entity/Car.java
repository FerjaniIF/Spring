package com.rental.car_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private Double price;
    private Integer numDoors;
    private Integer numSeats;
    private String fuelType;
    private String category;
    private String mode;
    private String description;
    private boolean available;
    
	public Long getId() {
		return id;
	}
	public String getModel() {
		return model;
	}
	public Double getPrice() {
		return price;
	}
	public Integer getNumDoors() {
		return numDoors;
	}
	public Integer getNumSeats() {
		return numSeats;
	}
	public String getFuelType() {
		return fuelType;
	}
	public String getCategory() {
		return category;
	}
	public String getMode() {
		return mode;
	}
	public String getDescription() {
		return description;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setNumDoors(Integer numDoors) {
		this.numDoors = numDoors;
	}
	public void setNumSeats(Integer numSeats) {
		this.numSeats = numSeats;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
    
	
    
}
