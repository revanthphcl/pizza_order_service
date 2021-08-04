package com.example.pizza_order_service.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pizza_order_service.model.Cart_Product;

public interface Cart_ProductRepository extends CrudRepository<Cart_Product, Long> {

}
