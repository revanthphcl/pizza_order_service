package com.example.pizza_order_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TOPPING")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topping {

	private @Id @GeneratedValue Long toppingId;
	private String name, description;
	private double price;
}
