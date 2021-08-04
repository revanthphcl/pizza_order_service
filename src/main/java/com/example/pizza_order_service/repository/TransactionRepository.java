package com.example.pizza_order_service.repository;

import java.util.List;
import com.example.pizza_order_service.model.Transaction;
import org.springframework.data.repository.CrudRepository;


public interface TransactionRepository extends CrudRepository<Transaction, Long>{
	public List<Transaction> findByUserID(Long userId);
}
