package com.cg.practice.Sprint_CustomerManagement.itemms.service;

import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;

public interface IItemService {

	public Item create(Double price, String description);

	public Item findByID(String itemID);

	public Item buyItem(String itemID, Long customerID);

}
