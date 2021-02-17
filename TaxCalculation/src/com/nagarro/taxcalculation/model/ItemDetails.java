package com.nagarro.taxcalculation.model;

public class ItemDetails {
	private String name;
	private Double price;
	private int quantity;
	private String type;
	
	public ItemDetails() {
	
	}
	
	public ItemDetails(String name, Double price, int quantity, String type) {
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPrice() {
		return price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}


}
