package com.cg.practice.Sprint_CustomerManagement.itemms.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.dao.*;
import java.time.LocalDateTime;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao dao;

	@Transactional
	@Override
	public Item create(Double price, String description) {

		Item item = new Item(price, description);
		LocalDateTime currentTime = LocalDateTime.now();
		item.setAddedDate(currentTime);
		return dao.add(item);
	}

	@Override
	public Item findByID(String itemID) {

		return dao.findByID(itemID);
	}

	@Override
	public Item buyItem(String itemID, Long customerID) {

		return null;
	}

}
