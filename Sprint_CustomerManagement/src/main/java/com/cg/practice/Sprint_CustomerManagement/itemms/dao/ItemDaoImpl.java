package com.cg.practice.Sprint_CustomerManagement.itemms.dao;

import javax.persistence.PersistenceContext;
import java.util.Random;

import org.springframework.stereotype.Repository;
import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;
import javax.persistence.EntityManager;

@Repository
public class ItemDaoImpl implements IItemDao {

	@PersistenceContext
	private EntityManager entityManager;

	public String generateStringId(Item item) {
		
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			
			int generatedDigit = random.nextInt(9);
			builder.append(generatedDigit);
		}
		
		String itemId = builder.toString();
		return itemId;
	}

	@Override
	public Item add(Item item) {

		String itemId = generateStringId(item);
		item.setId(itemId);
		entityManager.persist(item);
		return item;
	}

	@Override
	public Item update(Item item) {

		item = entityManager.merge(item);
		return item;
	}

	@Override
	public Item findByID(String itemID) {

		Item item = entityManager.find(Item.class, itemID);
		return item;
	}

}
