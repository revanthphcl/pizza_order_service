package com.example.pizza_order_service.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.pizza_order_service.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByName(String Name);
	public User findByuID(Long integer);
	
}
