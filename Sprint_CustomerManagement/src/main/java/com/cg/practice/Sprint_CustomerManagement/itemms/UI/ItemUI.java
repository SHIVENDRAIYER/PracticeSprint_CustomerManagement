package com.cg.practice.Sprint_CustomerManagement.itemms.UI;

import org.springframework.stereotype.Component;
import com.cg.practice.Sprint_CustomerManagement.itemms.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.practice.Sprint_CustomerManagement.itemms.service.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;

@Component
public class ItemUI {

	@Autowired
	private IItemService service;

	public void start() {

		try {
			Item piano = service.create(5000.0, "Music Piano");
			Item game = service.create(6000.0, "DB game");

			display(piano);
			display(game);

		} catch (Exception e) {

			System.out.println("Something went wrong!");
			e.printStackTrace();

		}
	}

	public void display(Item item) {
		
		System.out.println("Item: " + item.getId() + " " + item.getPrice() + " " + item.getDescription());
	}

}
