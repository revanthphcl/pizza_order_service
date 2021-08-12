package com.example.pizza_order_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pizza_order_service.model.Product;
import com.example.pizza_order_service.service.ProductService;


@Controller
public class ProductController {

	@Autowired
    private ProductService prodService;
		
	
   	@GetMapping("/Product/create")
	public ModelAndView getCreateProduct() {
   		Product prod = new Product();
		return new ModelAndView("createProduct", "fn", prod);       
	}

	@PostMapping("/Product/create")
	public ModelAndView postCreateProduct(Product prod) {
		Product newProd = this.save(prod);
		return new ModelAndView("create", "fn2", newProd);
	}
	
	@GetMapping("/Product/all")
	public ModelAndView listProducts() {
		List<Product> products = (List<Product>) prodService.findAll();
		return new ModelAndView("read","product", products);
	}
	
	@GetMapping("/Product/update")
	public ModelAndView getUpdateProduct() {
		Product prod = new Product();
		return new ModelAndView("UpdateProducts", "fn3" , prod);
	}
	
	@PostMapping("/Product/update")
	public ModelAndView postUpdateProduct(Product product) {
		Product updatedProd = this.save(product);
		return new ModelAndView("updateProducts2", "fn4", updatedProd);
	}
	
	@GetMapping(value="/Product/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") long id)  {  
		prodService.deleteProduct(id);
		return listProducts();
	}
	
	private Product save(Product prod) {
		return prodService.save(prod);
	}
}