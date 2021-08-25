package com.example.pizza_order_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.pizza_order_service.model.User;
import com.example.pizza_order_service.service.UserService;

@Controller
public class ContactUs {

	@Autowired
	UserService userService;
	
	@GetMapping("/contactUs")
	public String contactUsRedirect() {
		return "contactUs.html";
	}

	@PostMapping("/contactUs")
	public ModelAndView feedbackForm(@RequestParam(required=false) String name, @RequestParam(required=false) String email, @RequestParam(required=false) String message) {
		if(name==null || email==null || message==null) {
			return new ModelAndView("contactUs.html", "message", "Please try again");
		}
		return new ModelAndView("contactUs.html", "message", "Thank you for the feedback!");
	}
}