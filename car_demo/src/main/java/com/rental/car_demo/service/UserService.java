package com.rental.car_demo.service;

import com.rental.car_demo.entity.User;
import com.rental.car_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateUser(Long userId, User userDetails) {
        return userRepository.findById(userId).map(user -> {
            if (userDetails.getEmail() != null) {
                user.setEmail(userDetails.getEmail());
            }
            if (userDetails.getName() != null) {
                user.setName(userDetails.getName());
            }
            if (userDetails.getPassword() != null) {
                user.setPassword(userDetails.getPassword());
            }
            if (userDetails.getPhone() != null) {
                user.setPhone(userDetails.getPhone());
            }
            if (userDetails.getCountry() != null) {
                user.setCountry(userDetails.getCountry());
            }
            if (userDetails.getCity() != null) {
                user.setCity(userDetails.getCity());
            }
            if (userDetails.getUserRole() != null) {
                user.setUserRole(userDetails.getUserRole());
            }
            return userRepository.save(user);
        }).orElse(null);
    }

    public User getUserByEmail(String email) {
        return userRepository.findFirstByEmail(email).orElse(null);
    }
}
