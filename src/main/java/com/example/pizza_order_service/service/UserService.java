package com.example.pizza_order_service.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizza_order_service.model.User;
import com.example.pizza_order_service.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public void createUser(User user) {
		userRepo.save(user);
	}
	
	public void updateUser(User user) {
		User foundUser = userRepo.findByuID(user.getUserId());
		if (Objects.isNull(foundUser))
		{
			userRepo.save(user);
		}
	}
	
	public void deleteUser(User user) {
		userRepo.delete(user);
	}
	
	

}
