package com.example.pizza_order_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizza_order_service.model.User;
import com.example.pizza_order_service.service.UserService;

@RestController
@RequestMapping("/REST/User/")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "{name}", produces = "application/json")
	public User getUser(@PathVariable String name) {
		return userService.findUserByUserName(name);
	}
	
	@PostMapping(value = "")
	public void saveUser(User user) {
		userService.save(user);
	}
	
	@GetMapping(value = "")
	public List<User> getUsers() {
		return userService.findAll();
	}
	
	@DeleteMapping(value = "{name}")
	public void removeUser(@PathVariable String name) {
		userService.delete(name);
	}
}
