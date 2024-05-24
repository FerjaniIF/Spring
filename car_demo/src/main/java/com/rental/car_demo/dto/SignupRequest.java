package com.rental.car_demo.dto;

public class SignupRequest {
	private String email;
	private String name;
	private String password;
	private String phone; 
    private String country; 
    private String city; 
	
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	
	public String getPhone() {
        return phone;
    }

	 public String getCountry() {
	        return country;
	 }
	 
	 public String getCity() {
	        return city;
	}
	 
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
