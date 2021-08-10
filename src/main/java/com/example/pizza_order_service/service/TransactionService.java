package com.example.pizza_order_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizza_order_service.repository.TransactionRepository;
import com.example.pizza_order_service.model.Transaction;
import com.example.pizza_order_service.model.User;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepo;
	
	public void addTransaction(Transaction transaction) {
		transactionRepo.save(transaction);
	}
	
	public List<Transaction> listTransactionsByUser(User user){
		return transactionRepo.findByUser(user);
	}

}
