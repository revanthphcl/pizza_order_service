package com.example.pizza_order_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
	public String load(Model model) {
		model.addAttribute("id", "nope");
		return "login.html";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(required=false) String username, @RequestParam(required=false) String pass, Model model) {
		model.addAttribute("id", "nopeiddynope");
		if(username!=null && pass!=null) {									//JS should handle nulls and whitespace...
			User temp = userService.findUserByUserName(username);
			if(temp!=null && pass.equals(temp.getPassword())) {
				System.out.println("logged in!");
				return "landing.html";
			}
			else {
				System.out.println("user not found/invalid pass");
				return "login.html";
			}
		}
		return "login.html";
	}
	
	@GetMapping("/createAccount")
	public String create(@RequestParam(required=false) String username, @RequestParam(required=false) String pass1, @RequestParam(required=false) String pass2) {
		if(pass1!=pass2) {
			
		}
		if(username!=null && pass1!=null && pass2!=null) {					//JS should handle nulls and whitespace...
			User user = new User();
			user.setName(username);
			user.setPassword(pass1);
			userService.save(user);
			System.out.println("acct created. Redirecting...");
			return "login.html";
		}
		else
			return "createAccount.html";		
	}
	
//	@GetMapping("/login")
//	public ModelAndView getLoginPage() {
//		User user = new User();
//		return new ModelAndView("login", "fn5", user);
//	}
//	
//	@GetMapping("/registration")
//	public ModelAndView getCreateUser() {
//		User user = new User();
//		return new ModelAndView("createUser", "fn6", user);
//	}
//	
//	@PostMapping("/registration")
//	public ModelAndView postCreateUser(User user) {
//		boolean exists = userService.userExists(user);
//		if (exists) {
//			String message = "User name already exists!";
//			return new ModelAndView("errorPage", "fn7", message);
//		} else {
//			userService.save(user);
//			return getLoginPage();			
//		}
//
//	}
}
