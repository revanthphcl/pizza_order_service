package com.example.pizza_order_service.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizza_order_service.model.Product;
import com.example.pizza_order_service.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository prodRepo;
	
	public void createProduct(Product prod) {
		prodRepo.save(prod);
	}
	
	public void updateProduct(Product prod) {
		Optional<Product> foundProduct = prodRepo.findById(prod.getProductId());
		if (Objects.isNull(foundProduct))
		{
			prodRepo.save(prod);
		}
	}
	
	public void deleteProduct(Product prod) {
		prodRepo.delete(prod);
	}
	
	

}