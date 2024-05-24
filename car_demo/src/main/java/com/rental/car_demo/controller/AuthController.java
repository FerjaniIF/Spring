package com.rental.car_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rental.car_demo.dto.LoginRequest;
import com.rental.car_demo.dto.SignupRequest;
import com.rental.car_demo.dto.UserDto;
import com.rental.car_demo.service.auth.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUpCustomer(@RequestBody SignupRequest signupRequest){
        if(authService.hasCustomerWithEmail(signupRequest.getEmail()))
            return new ResponseEntity<>("Customer already exists with this email", HttpStatus.NOT_ACCEPTABLE);
        
        UserDto createdCustomerDto = authService.createCustomer(signupRequest);
        if(createdCustomerDto == null) 
            return new ResponseEntity<>("Customer not created, Come again later", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginRequest loginRequest){
        UserDto authenticatedUser = authService.authenticate(loginRequest);
        
        if(authenticatedUser != null)
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        else
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }
    
}
