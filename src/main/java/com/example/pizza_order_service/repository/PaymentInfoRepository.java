package com.example.pizza_order_service.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pizza_order_service.model.PaymentInfo;

public interface PaymentInfoRepository extends CrudRepository<PaymentInfo, Long>{

}
