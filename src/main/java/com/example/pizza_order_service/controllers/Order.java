package com.example.pizza_order_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.pizza_order_service.model.Product;
import com.example.pizza_order_service.service.ProductService;

@Controller
public class Order {

	@Autowired
	ProductService productService;
	
	@GetMapping("/order")
	public String contactUsRedirect() {
		System.out.println(productService.findAll());
		return "order.html";
	}
}