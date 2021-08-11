package com.example.pizza_order_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pizza_order_service.model.User;
import com.example.pizza_order_service.service.UserService;

@Controller
public class SecurityController {

	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public ModelAndView getLoginPage() {
		User user = new User();
		return new ModelAndView("login", "fn5", user);       
	}

	@PostMapping("/login")
	public ModelAndView postLoginPage() {
		return new ModelAndView("filler");
	}
	
	@GetMapping("/registration")
	public ModelAndView getCreateUser() {
		return new ModelAndView("filler");
	}
	
	@PostMapping("/registration")
	public ModelAndView postCreateUser(User user) {
		userService.save(user);
		return new ModelAndView("filler");
	}
}
