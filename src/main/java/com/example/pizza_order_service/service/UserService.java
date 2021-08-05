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
	UserRepository ur;
	
	public void createUser(User u) {
		ur.save(u);
	}
	
	public void updateUser(User u) {
		User foundUser = ur.findByuID(u.getUserId());
		if (Objects.isNull(foundUser))
		{
			ur.save(u);
		}
	}
	
	public void deleteUser(User u) {
		ur.delete(u);
	}
	
	

}
