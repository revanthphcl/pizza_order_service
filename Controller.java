package com.example.pizza_order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.pizza_order_service.model.Product;
import com.example.pizza_order_service.repository.AddonRepository;
import com.example.pizza_order_service.repository.CartRepository;
import com.example.pizza_order_service.repository.Cart_ProductRepository;
import com.example.pizza_order_service.repository.Cart_Product_AddonRepository;
import com.example.pizza_order_service.repository.PaymentInfoRepository;
import com.example.pizza_order_service.repository.ProductRepository;
import com.example.pizza_order_service.repository.TransactionRepository;
import com.example.pizza_order_service.repository.UserRepository;


@RestController
public class Controller {

	@Autowired
    private AddonRepository AddonData;
	
	@Autowired
    private CartRepository CartData;
	
	@Autowired
    private Cart_ProductRepository Cart_ProductData;
	
	@Autowired
    private Cart_Product_AddonRepository Cart_Product_AddonData;
	
	@Autowired
    private PaymentInfoRepository PaymentInfoData;
	
	@Autowired
    private ProductRepository ProductData;
	
	@Autowired
    private TransactionRepository TransactionData;
	
	@Autowired
    private UserRepository UserData;
	
	//Create Product
   	@GetMapping("/create")
	public ModelAndView getPage() {
   		Product prod = new Product();
		return new ModelAndView("createProduct", "fn", prod);       
	}

	@PostMapping("/create")
	public ModelAndView createProduct(Product prod) {
		Product newProd = ProductData.save(prod);
		
		return new ModelAndView("create", "fn2", newProd);

	}
	
	//Read/Display product
	@GetMapping("/read")
	public ModelAndView listProduct() {
		List<Product> products = (List<Product>) ProductData.findAll();
		return new ModelAndView("read","product", products);
	}
	
	//Update/Edit product
	@GetMapping("/update")
	public ModelAndView getupdate() {
		Product prod = new Product();


		return new ModelAndView("UpdateProducts", "fn3" , prod);
	}
	@PostMapping("/update")
	public ModelAndView updateProd(Product product) {

		ProductData.save(product);
		
		return new ModelAndView("updateProducts2", "fn4", product);
	}
	
	
	//Delete a product by id
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") long theId)  
	{  

		ProductData.deleteById(theId);
		return "Product deleted successfully....(insert hyperlink to desired page)";

	} 
	
}