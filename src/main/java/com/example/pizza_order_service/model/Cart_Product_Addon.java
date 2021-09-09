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
@Table(name = "CART_PRODUCT_ADDON")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart_Product_Addon {

	private @Id @GeneratedValue Long cartProductAddonId;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_CartProduct")
	private Cart_Product cartProduct;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_Addon")
	private Addon addon;
}
