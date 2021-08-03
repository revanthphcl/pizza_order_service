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
@Table(name="PAYMENT_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {

	private @Id @GeneratedValue Long paymentInfoId;
	private String address;
	private long creditCardNo;
	private int cvv;
	private Date expirationDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_userId", referencedColumnName = "userId")
	private long fk_userId;
}
