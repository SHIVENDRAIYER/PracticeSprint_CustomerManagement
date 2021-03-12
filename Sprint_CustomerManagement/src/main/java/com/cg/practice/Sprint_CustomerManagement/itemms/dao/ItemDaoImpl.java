package com.cg.practice.Sprint_CustomerManagement.itemms.dao;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;
import javax.persistence.EntityManager;

@Repository
public class ItemDaoImpl implements IItemDao {

	@PersistenceContext
	private EntityManager entityManager;

	public String generateStringId(Item item) {

		String s = "hirudegarn";
		s = s + Math.random();
		return s;

	}

	@Override
	public Item add(Item item) {

		String id = generateStringId(item);
		item.setId(id);
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
