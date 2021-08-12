package com.example.pizza_order_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizza_order_service.model.User;
import com.example.pizza_order_service.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public void save(User user) {
		userRepo.save(user);
	}

	public User findUserByUserName(String username) {
		return userRepo.getUserByName(username);
	}

	
	public boolean userExists(User user) {
		Optional<User> retrievedUser = userRepo.findById(user.getUserId());
		return retrievedUser.isPresent();
	}
}
