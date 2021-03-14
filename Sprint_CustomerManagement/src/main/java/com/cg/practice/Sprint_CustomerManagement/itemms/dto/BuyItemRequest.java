package com.cg.practice.Sprint_CustomerManagement.itemms.dto;

public class BuyItemRequest {

	private String itemID;
	private long custID;

	public BuyItemRequest() {

	}

	public String getItemID() {

		return itemID;
	}

	public void setItemID(String itemID) {

		this.itemID = itemID;
	}

	public long getCustID() {

		return custID;
	}

	public void setCustID(long custID) {

		this.custID = custID;
	}

}
