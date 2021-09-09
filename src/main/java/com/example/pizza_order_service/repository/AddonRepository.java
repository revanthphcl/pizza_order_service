package com.example.pizza_order_service.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pizza_order_service.model.Addon;

public interface AddonRepository extends CrudRepository<Addon, Long>{

}
