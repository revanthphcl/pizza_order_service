package com.example.pizza_order_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pizza_order_service.model.Product;
import com.example.pizza_order_service.service.ProductService;

@Controller
public class Menu {
	
	@Autowired
    private ProductService prodService;
	
	@GetMapping("/menu")
	public ModelAndView contactUsRedirect() {
		List<Product> products = prodService.findAll();
		String output = "";
		
		for(int counter=0; counter<products.size(); counter++) {
			Product currentProd = products.get(counter);
			output+="<tr><td>"+currentProd.getName()+"</td><td>"+currentProd.getDescription()+"</td><td>"+currentProd.getPrice()+"</td></tr>";
		}
		return new ModelAndView("menu.html", "menu", output);
	}
}