package com.example.pizza_order_service.service;

import java.util.List;
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
		Product updateProduct = this.find(prod.getProductId());
		if (!Objects.isNull(updateProduct)){
			prodRepo.save(prod);
		}
	}
	
	public void deleteProduct(Product prod) {
		prodRepo.delete(prod);
	}
	
	public void deleteProduct(Long id) {
		Product product = this.find(id);
		prodRepo.delete(product);
	}

	public Product save(Product prod) {
		return prodRepo.save(prod);
	}
	
	public List<Product> findAll() {
		return (List<Product>) prodRepo.findAll();
	}
	
	public Product find(Long id) {
		Optional<Product> product = prodRepo.findById(id);
		Product toReturn = product.isPresent() ? product.get() : null;
		return toReturn;
	}
}