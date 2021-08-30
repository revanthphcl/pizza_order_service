package com.example.pizza_order_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pizza_order_service.service.ProductService;

@Controller
public class Menu {
	
	@Autowired
    private ProductService prodService;
	
	@GetMapping("/menu")
	public ModelAndView contactUsRedirect() {
		//System.out.println(prodService.findAll());
		return new ModelAndView("menu.html", "menu", prodService.findAll());
	}
}