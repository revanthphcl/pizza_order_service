package com.example.pizza_order_service.model;

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
@Table(name="CART")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

	private @Id @GeneratedValue Long cartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_User")
	private User user;
}
