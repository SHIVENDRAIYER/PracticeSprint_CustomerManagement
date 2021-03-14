package com.cg.practice.Sprint_CustomerManagement.customerms.UI;

import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.service.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.practice.Sprint_CustomerManagement.customerms.exceptions.*;
import com.cg.practice.Sprint_CustomerManagement.customerms.service.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.exceptions.*;

@Component
public class CustomerUI {

	@Autowired
	private ICustomerService custService;

	@Autowired
	private IItemService itemService;

	public void start() {

		try {

			Customer shivendra = custService.createCustomer("Shivendra");
			Customer iyer = custService.createCustomer("Iyer");

			displayCustomer(shivendra);
			displayCustomer(iyer);

			Customer fetchedCustomer = custService.findByID(4L);
			displayCustomer(fetchedCustomer);

			Long id = shivendra.getCustID();
			Customer shivendraAmount = custService.addAmount(id, 1000.0);
			displayCustomer(shivendraAmount);

			Set<Item> item1 = custService.itemsBoughtByCustomer(shivendra.getCustID());
			for (Item item : item1) {

				System.out.println(item.getDescription());
			}

			Item piano = itemService.create(5000.0, "Music Piano");
			Item game = itemService.create(6000.0, "DB game");

			displayItem(piano);
			displayItem(game);

			String itemId = piano.getItemID();
			Item findItem = itemService.findByID(itemId);
			displayItem(findItem);

			Item item_1 = itemService.buyItem(piano.getItemID(), shivendra.getCustID());
			System.out.println("Item bought is = " + item_1.getDescription());

			Item item_2 = itemService.buyItem(game.getItemID(), iyer.getCustID());
			System.out.println("Item bought is = " + item_2.getDescription());

		} catch (InvalidCustomerIdException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (InvalidCustomerNameException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (CustomerNotFoundException e) {

			System.out.println("customer not found");
			e.printStackTrace();

		} catch (ItemNotFoundException e) {

			System.out.println("item not found");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Something went wrong!");
			e.printStackTrace();
		}
	}

	public void displayCustomer(Customer customer) {

		Account account = customer.getAccount();
		System.out.println("Customer: " + customer.getCustID() + " " + customer.getCustName() + " "
				+ account.getAccountID() + " " + account.getBalance() + " " + account.getCreated());
	}

	public void displayItem(Item item) {

		System.out.println("Item: " + item.getItemID() + " " + item.getPrice() + " " + item.getDescription() + " "
				+ item.getAddedDate());

	}
}
