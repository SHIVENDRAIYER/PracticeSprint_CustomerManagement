package com.cg.practice.Sprint_CustomerManagement.itemms.service;

import javax.transaction.Transactional;
import com.cg.practice.Sprint_CustomerManagement.itemms.exceptions.*;
import java.util.*;
import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.dao.*;
import com.cg.practice.Sprint_CustomerManagement.customerms.exceptions.*;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import com.cg.practice.Sprint_CustomerManagement.customerms.dao.*;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	// private IItemDao itemDao;
	private IItemRepository itemRepository;
	@Autowired
	EntityManager entityManager;
	@Autowired
	// private ICustomerDao customerDao;
	private ICustomerRepository customerRepository;

	public String generateStringId(Item item) {

		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {

			int generatedDigit = random.nextInt(9);
			sb.append(generatedDigit);
		}

		String itemId = sb.toString();
		return itemId;
	}

	@Transactional
	@Override
	public Item create(Double price, String description) {

		/* Item item = new Item(); 
		 * LocalDateTime localDateTime = LocalDateTime.now();
		 * item.setPrice(price); 
		 * item.setDescription(description);
		 * item.setAddedDate(localDateTime);
		 * item = itemDao.add(item);
		 * return item;
		 */

		Item item = new Item();
		LocalDateTime localDateTime = LocalDateTime.now();

		item.setPrice(price);
		item.setDescription(description);
		item.setAddedDate(localDateTime);

		String itemID = generateStringId(item);
		item.setId(itemID);

		item = itemRepository.save(item);
		return item;

	}

	@Override
	public Item findByID(String itemID) {

		// return itemDao.findByID(itemID);

		Optional<Item> optional = itemRepository.findById(itemID);
		if (!optional.isPresent()) {
			throw new ItemNotFoundException("Item not available for this id, Invalid customer id");
		}
		return optional.get();
	}

	@Transactional
	@Override
	public Item buyItem(String itemID, Long customerID) {

		/* Item item = findByID(itemID); 
		 * Customer customer = customerDao.findByID(customerID); 
		 * item.setBoughtBy(customer);
         * itemDao.update(item);
         * Set<Item> items = customer.getBoughtItems(); 
         * if (items == null) {
		 * items = new HashSet<>(); 
		 * customer.setBoughtItems(items);
		 *  } 
		 * items.add(item);
		 * customerDao.update(customer); 
		 * return item;
		 */

		Optional<Customer> custOptional = customerRepository.findById(customerID);
		if (!custOptional.isPresent()) {
			throw new CustomerNotFoundException("Customer not available for this custId");
		}
		Customer customer = custOptional.get();

		Optional<Item> itemOptional = itemRepository.findById(itemID);
		if (!itemOptional.isPresent()) {
			throw new ItemNotFoundException("Item not available for this itemId , please enter correct custId");
		}

		Item item = itemOptional.get();
		item.setBoughtBy(customer);
		item = itemRepository.save(item);

		Set<Item> set = customer.getBoughtItems();
		if (set == null) {
			set = new HashSet<>();
			customer.setBoughtItems(set);
		}
		set.add(item);
		customerRepository.save(customer);
		return item;

	}

}
