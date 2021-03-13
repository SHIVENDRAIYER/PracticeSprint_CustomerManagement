package com.cg.practice.Sprint_CustomerManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.cg.practice.Sprint_CustomerManagement.customerms.UI.*;

@SpringBootApplication
public class SprintCustomerManagementApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SprintCustomerManagementApplication.class, args);

		CustomerUI customerUI = context.getBean(CustomerUI.class);
		customerUI.start();
	

	}

}
