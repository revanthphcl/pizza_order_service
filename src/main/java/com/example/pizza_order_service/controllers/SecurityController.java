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
public class SecurityController {

	@Autowired
	UserService userService;
	
	@GetMapping({"/","/landing"})
	public String landing() {
		return "landing.html";
	}
	
	@GetMapping("/login")
	public String loginRedirect() {
		return "login.html";
	}
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam(required=false) String username, @RequestParam(required=false) String pass) {
		System.out.println("here");
		if(username!=null && pass!=null) {														//only run the following if all fields are filled. Note that HTML handles incomplete field errors
			System.out.println("there");
			User temp = userService.findUserByUserName(username);								//search for entered username
			
			if(temp==null)																		//check for invalid username
				return new ModelAndView("login.html", "error", "Username not found");
			
			if(!temp.getPassword().equals(pass))												//check for incorrect password
				return new ModelAndView("login.html", "error", "Incorrect password");
			
			return new ModelAndView("landing.html", "message", "Successfully signed in!");		//redirect user to landing on success
		}
		return new ModelAndView("login.html");
	}
	
	@GetMapping("/createAccount")
	public String createAccountRedirect() {
		return "createAccount.html";
	}
	
	@PostMapping("/createAccount")
	public ModelAndView create(@RequestParam(required=false) String username, @RequestParam(required=false) String pass1, @RequestParam(required=false) String pass2) {
		if(username!=null && pass1!=null && pass2!=null) {										//only run the following if all fields are filled. Note that HTML handles incomplete field errors
			if(!pass1.equals(pass2))															//check for password mismatch
				return new ModelAndView("createAccount.html", "error", "Please confirm your passwords match");
			
			User duplicate = userService.findUserByUserName(username);							//check for duplicate username
			if(duplicate!=null)
				return new ModelAndView("createAccount.html", "error", "Please choose a unique username");
			
			User user = new User();																//this is only run once above conditions are met
			user.setName(username);
			user.setPassword(pass1);
			user.setRole("USER");
			userService.save(user);
			return new ModelAndView("login.html", "message", "Account successfully created!");	//redirect user to login
		}
		else
			return new ModelAndView("createAccount.html");		
	}
}
