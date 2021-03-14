package com.cg.practice.Sprint_CustomerManagement.itemms.service;

import javax.transaction.Transactional;
import java.util.*;
import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.dao.*;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import com.cg.practice.Sprint_CustomerManagement.customerms.dao.*;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao itemDao;
	@Autowired
	EntityManager entityManager;
	@Autowired
	private ICustomerDao customerDao;

	@Transactional
	@Override
	public Item create(Double price, String description) {

		Item item = new Item();
		LocalDateTime localDateTime = LocalDateTime.now();

		item.setPrice(price);
		item.setDescription(description);
		item.setAddedDate(localDateTime);

		item = itemDao.add(item);
		return item;
	}

	@Override
	public Item findByID(String itemID) {

		return itemDao.findByID(itemID);
	}

	@Transactional
	@Override
	public Item buyItem(String itemID, Long customerID) {

		Item item = findByID(itemID);
		Customer customer = customerDao.findByID(customerID);
		item.setBoughtBy(customer);
		
		itemDao.update(item);
		Set<Item>items=customer.getBoughtItems();
		if(items==null)
		{
			items=new HashSet<>();
			customer.setBoughtItems(items);
		}
		items.add(item);
		customerDao.update(customer);
		return item;
	}

}
