package com.example.pizza_order_service.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizza_order_service.model.Product;
import com.example.pizza_order_service.service.ProductService;

@RestController
@RequestMapping("/REST/Product/")
public class ProductRestController {

	@Autowired
    private ProductService prodService;
	
	@GetMapping(value = "{id}", produces = "application/json")
	public Product getProduct(@PathVariable long id) {
		return prodService.find(id);
	}
	
	@PostMapping(value = "")
	public void saveProduct(@RequestBody Product prod) {
		prodService.save(prod);
	}
	
	@GetMapping(value = "", produces = "application/json")
	public List<Product> getProducts(){
		return prodService.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteProduct(@PathVariable long id) {
		prodService.deleteProduct(id);
	}
}
