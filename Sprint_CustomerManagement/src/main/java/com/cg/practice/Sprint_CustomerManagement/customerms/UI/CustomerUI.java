package com.cg.practice.Sprint_CustomerManagement.customerms.UI;

import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.practice.Sprint_CustomerManagement.customerms.exceptions.*;
import com.cg.practice.Sprint_CustomerManagement.customerms.service.*;

@Component
public class CustomerUI {
	
	@Autowired
	private ICustomerService service;

	public void start() {
		
		try {

			Customer shivendra = service.createCustomer("Shivendra");
			Customer iyer = service.createCustomer("Iyer");

			display(shivendra);
			display(iyer);

			Long id = shivendra.getCustId();

			Customer fetchedCustomer = service.findByID(id);
			display(fetchedCustomer);
			
			
			Customer shivendraAmount = service.addAmount(4010027L, 1000.0);
			display(shivendraAmount);
			

		} catch (InvalidIdException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
			
		} catch (InvalidNameException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Something went wrong!");
			e.printStackTrace();
		}
	}

	public void display(Customer customer) {

		System.out.println(customer.toString());
	}
}
