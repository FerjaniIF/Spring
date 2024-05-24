package com.rental.car_demo.service.auth;

import com.rental.car_demo.dto.LoginRequest;
import com.rental.car_demo.dto.SignupRequest;
import com.rental.car_demo.dto.UserDto;

public interface AuthService {
    UserDto createCustomer(SignupRequest signupRequest);
    boolean hasCustomerWithEmail(String email);
    UserDto authenticate(LoginRequest loginRequest);
}
