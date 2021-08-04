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
	private String deliveryOrPickup, deliveryAddress, refundReason;
	private boolean onlinePayment, paymentRecieved, refunded;
	private Date purchaseDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_paymentInfoId")
	private PaymentInfo fk_PaymentInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_User")
	private User fk_User;
}
