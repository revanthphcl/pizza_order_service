package com.example.pizza_order_service.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRANSACTION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	private @Id @GeneratedValue Long transactionId;
	private String deliveryOrPickup;
	private boolean onlinePayment;
	private Date purchaseDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentinfo_paymentInfoId", referencedColumnName = "paymentInfoId")
	private long fk_paymentInfoId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_userId", referencedColumnName = "userId")
	private long fk_userId;
}
