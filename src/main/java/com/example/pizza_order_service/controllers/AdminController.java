package com.example.pizza_order_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pizza_order_service.model.Addon;
import com.example.pizza_order_service.model.Product;
import com.example.pizza_order_service.model.User;
import com.example.pizza_order_service.service.AddonService;
import com.example.pizza_order_service.service.ProductService;
import com.example.pizza_order_service.service.UserService;


@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
    private ProductService prodService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddonService addonService;
	
	@GetMapping("")
	public ModelAndView listProducts() {
		List<Product> products = prodService.findAll();
		return new ModelAndView("read1","product", products);
	}
	
	@GetMapping("")
	public ModelAndView listAddons() {
		List<Addon> addons = addonService.findAll();
		return new ModelAndView("read2","addon", addons);
	}
	
	//- Create Product
	
	
	@GetMapping("/Product")
	public String createProducts(ModelMap model) {
		Iterable<Product> results = prodService.findAll();
		model.addAttribute("products", results);
		return "product";
	}
	//Create Toppings
	

	@GetMapping("/Toppings")
	public String createToppings(ModelMap model) {
		Iterable<Addon> results = addonService.findAll();
		model.addAttribute("toppings", results);
		return "Topping";
	}
	
	
	// - Promote Users
	
	@PutMapping("/employees/{id}")
	User promoteUser(@RequestBody User newUser, @PathVariable String username) {
	    
	    return userService.findUserByUserName(username)
	      .map(employee -> {
	        employee.setName(newEmployee.getName());
	        employee.setRole(newEmployee.getRole());
	        return repository.save(employee);
	      })
	      .orElseGet(() -> {
	        newEmployee.setId(id);
	        return repository.save(newEmployee);
	      });
	    
	
	  }

	
	//- Delete Product
	
	@DeleteMapping(value="/deleteProd/{id}")
	public ModelAndView deleteAProduct(@PathVariable("id") long id)  {  
		prodService.deleteProduct(id);
		return listProducts();
	}

	
	//- Delete Toppings
	
	@DeleteMapping(value="/deleteAddon/{id}")
	public ModelAndView deleteAnAddon(@PathVariable("id") long id)  {  
		addonService.deleteAddon(id);
		return listAddons();
	}

	
	
}
