package com.rental.car_demo.service.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.car_demo.dto.LoginRequest;
import com.rental.car_demo.dto.SignupRequest;
import com.rental.car_demo.dto.UserDto;
import com.rental.car_demo.entity.User;
import com.rental.car_demo.enums.UserRole;
import com.rental.car_demo.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {
        logger.info("Creating customer with email: {}", signupRequest.getEmail());
        try {
            User user = new User();
            user.setName(signupRequest.getName());
            user.setEmail(signupRequest.getEmail());
            user.setPassword(signupRequest.getPassword());
            user.setPhone(signupRequest.getPhone());
            user.setCountry(signupRequest.getCountry());
            user.setCity(signupRequest.getCity());
            user.setUserRole(UserRole.CUSTOMER);
            User createdUser = userRepository.save(user);
            UserDto userDto = new UserDto();
            userDto.setId(createdUser.getId());
            logger.info("Customer created with ID: {}", createdUser.getId());
            return userDto;
        } catch (Exception e) {
            logger.error("Error creating customer", e);
            throw e;
        }
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        logger.info("Checking if customer exists with email: {}", email);
        return userRepository.findFirstByEmail(email).isPresent();
    }
    
    
    @Override
    public UserDto authenticate(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        User user = userRepository.findFirstByEmail(username).orElse(null);

        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            return userDto;  
        } else {
            return null;
        }
    }

}
