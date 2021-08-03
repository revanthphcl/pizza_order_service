package com.example.pizza_order_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private @Id @GeneratedValue Long productId;
	private String name, description;
	private double price;
}
