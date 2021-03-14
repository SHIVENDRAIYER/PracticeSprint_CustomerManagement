package com.cg.practice.Sprint_CustomerManagement.itemms.dto;

import javax.persistence.ManyToOne;
import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;
public class ItemDetails {
	
	private String itemID;
	private double price;
	private String description;
	private long customerID;
	private String customerName;
	
	@ManyToOne
	private Customer boughtBy;
	
	public ItemDetails() {
		
		
	}

	public String getItemID() {
		
		return itemID;
	}

	public void setItemID(String itemID) {
		
		this.itemID = itemID;
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

	public long getCustomerID() {
		
		return customerID;
	}

	public void setCustomerID(long customerID) {
		
		this.customerID = customerID;
	}

	public String getCustomerName() {
		
		return customerName;
	}

	public void setCustomerName(String customerName) {
		
		this.customerName = customerName;
	}

	public Customer getBoughtBy() {
		
		return boughtBy;
	}

	public void setBoughtBy(Customer boughtBy) {
		
		this.boughtBy = boughtBy;
	}
	
	
	
	
	

}
