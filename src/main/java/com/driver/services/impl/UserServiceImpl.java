package com.driver.services.impl;

import com.driver.model.User;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository4;
    @Override
    public void deleteUser(Integer userId) {
        // Check if the user exists
        if (!userRepository4.existsById(userId)) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        // Delete the user
        userRepository4.deleteById(userId);
    }

    @Override
    public ResponseEntity<User> updatePassword(Integer userId, String password) {
        // Check if the user exists
        User user = userRepository4.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        // Update the password
        user.setPassword(password);
        userRepository4.save(user);

        // Return the updated user
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @Override
    public void register(String name, String phoneNumber, String password) {
        //Check if the phone number is already registered

        if (userRepository4.existsByPhoneNumber(phoneNumber)) {
            throw new RuntimeException("Phone number already registered");
        }

        // Create a new user entity
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);

        // Encode the password before storing it
        user.setPassword(password);

        // Save the user
        userRepository4.save(user);

    }
}
