package com.example.pizza_order_service.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pizza_order_service.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
