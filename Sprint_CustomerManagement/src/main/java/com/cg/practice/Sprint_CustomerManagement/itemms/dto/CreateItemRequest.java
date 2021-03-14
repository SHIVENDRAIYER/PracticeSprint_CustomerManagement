package com.cg.practice.Sprint_CustomerManagement.itemms.dto;

public class CreateItemRequest {

	private double price;
	private String description;

	public CreateItemRequest() {

	}

	public double getPrice() {

		return price;
	}

	public void setPrice(double price) {

		this.price = price;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

}
