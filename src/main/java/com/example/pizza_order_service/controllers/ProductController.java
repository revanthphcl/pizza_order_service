package com.example.pizza_order_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pizza_order_service.model.Product;
import com.example.pizza_order_service.service.ProductService;


@Controller
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
    private ProductService prodService;
		
	
   	@GetMapping("")
	public ModelAndView getProduct() {
   		Product prod = new Product();
		return new ModelAndView("createProduct", "fn", prod);       
	}

	@PostMapping("")
	public ModelAndView postProduct(Product prod) {
		Product newProd = this.save(prod);
		return new ModelAndView("create", "fn2", newProd);
	}
	
	@GetMapping("")
	public ModelAndView listProducts() {
		List<Product> products = prodService.findAll();
		return new ModelAndView("read","product", products);
	}
	
	@GetMapping("/update")
	public ModelAndView UpdateProduct() {
		Product prod = new Product();
		return new ModelAndView("UpdateProducts", "fn3" , prod);
	}
	
	@PutMapping(value="{id}")
	public ModelAndView saveUpdatedProduct(Product product) {
		Product updatedProd = this.save(product);
		return new ModelAndView("updateProducts2", "fn4", updatedProd);
	}
	
	@DeleteMapping(value="/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") long id)  {  
		prodService.deleteProduct(id);
		return listProducts();
	}
	
	private Product save(Product prod) {
		return prodService.save(prod);
	}
}