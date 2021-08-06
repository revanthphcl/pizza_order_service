package com.example.pizza_order_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizza_order_service.repository.TransactionRepository;
import com.example.pizza_order_service.model.Transaction;
import com.example.pizza_order_service.model.User;

@Service
public class TransactionServicec {
	
	@Autowired
	TransactionRepository tr;
	
	public void addTransaction(Transaction t) {
		tr.save(t);
	}
	
	public List<Transaction> listTransactionsByUser(User u){
		return tr.findByUser(u);
	}

}
