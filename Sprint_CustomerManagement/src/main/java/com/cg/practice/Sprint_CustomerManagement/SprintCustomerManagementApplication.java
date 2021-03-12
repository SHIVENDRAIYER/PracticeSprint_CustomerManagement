package com.cg.practice.Sprint_CustomerManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.cg.practice.Sprint_CustomerManagement.customerms.UI.*;
import com.cg.practice.Sprint_CustomerManagement.itemms.UI.*;

@SpringBootApplication
public class SprintCustomerManagementApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SprintCustomerManagementApplication.class, args);

		/*CustomerUI customerUI = context.getBean(CustomerUI.class);
		customerUI.start();
        */
		ItemUI itemUI = context.getBean(ItemUI.class);
		itemUI.start();

	}

}
