package com.ty.springBoot_foodApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Items {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_id;
	@NotNull(message = "name should not be null")
	@NotBlank(message = "name should not be blank")
	private String item_name;
	private double cost;
//	@NotNull(message = "quantity should not be null")
//	@NotBlank(message = "quantity should not be blank")
	private int quantity;
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
