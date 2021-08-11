package com.example.pizza_order_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.pizza_order_service.model.Product;
import com.example.pizza_order_service.model.User;
import com.example.pizza_order_service.repository.AddonRepository;
import com.example.pizza_order_service.repository.CartRepository;
import com.example.pizza_order_service.repository.Cart_ProductRepository;
import com.example.pizza_order_service.repository.Cart_Product_AddonRepository;
import com.example.pizza_order_service.repository.PaymentInfoRepository;
import com.example.pizza_order_service.repository.ProductRepository;
import com.example.pizza_order_service.repository.TransactionRepository;
import com.example.pizza_order_service.repository.UserRepository;
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

   	//refactor
	@PostMapping("/Product/create")
	public ModelAndView postCreateProduct(Product prod) {
		Product newProd = prodService.save(prod);
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
	
	//refactor
	@PostMapping("/Product/update")
	public ModelAndView postUpdateProduct(Product product) {
		prodService.save(product);
		return new ModelAndView("updateProducts2", "fn4", product);
	}
	
	
	@GetMapping(value="/Product/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") long id)  {  
		prodService.deleteProduct(id);
		return new ModelAndView("/Product/all"); //This is probably incorrect, please test. 

	} 
}