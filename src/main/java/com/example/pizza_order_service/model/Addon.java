package com.example.pizza_order_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ADDON")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Addon {

	private @Id @GeneratedValue Long addonId;
	private String name, description;
	private double price;
}
