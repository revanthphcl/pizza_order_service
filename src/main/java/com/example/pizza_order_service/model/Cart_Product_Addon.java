package com.example.pizza_order_service.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_CartProduct")
	private Cart_Product fk_CartProduct;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_Addon")
	private Addon fk_Addon;
}
