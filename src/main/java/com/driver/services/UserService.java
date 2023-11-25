package com.driver.services;


import com.driver.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

	void deleteUser(Integer userId);
	ResponseEntity<User> updatePassword(Integer userId, String password);
    void register(String name, String phoneNumber, String password);
}
