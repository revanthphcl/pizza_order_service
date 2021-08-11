package com.example.pizza_order_service.service;

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
}
