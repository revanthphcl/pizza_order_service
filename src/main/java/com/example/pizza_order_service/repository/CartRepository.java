package com.example.pizza_order_service.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pizza_order_service.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Long>{

}
