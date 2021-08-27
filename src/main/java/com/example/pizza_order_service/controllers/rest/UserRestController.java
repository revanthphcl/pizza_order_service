package com.example.pizza_order_service.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public void saveUser(@Valid @RequestBody NewUserRequest newUser) {
		User alreadyExists = userService.findUserByUserName(newUser.getName());
		
		if (alreadyExists != null) {
			//create custom request saying user already exists
		}
		
		User user = new User();
		user.setName(newUser.getName());
		user.setEmail(newUser.getEmail());
		user.setPassword(newUser.getPassword());
		user.setAddress(newUser.getAddress());
		user.setPhoneNo(newUser.getPhoneNo());
		
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
