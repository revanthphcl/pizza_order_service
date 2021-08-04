package com.example.pizza_order_service.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CART_PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart_Product {

	private @Id @GeneratedValue Long cartProductId;
	private String size;
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_Cart")
	private Cart cart;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_Product")
	private Product product;
	
}
