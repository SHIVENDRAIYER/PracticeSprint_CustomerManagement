package com.cg.practice.Sprint_CustomerManagement;

import org.springframework.boot.SpringApplication;
import org.slf4j.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.cg.practice.Sprint_CustomerManagement.customerms.UI.*;

@SpringBootApplication
public class SprintCustomerManagementApplication {

	private static final Logger Log = LoggerFactory.getLogger(SprintCustomerManagementApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SprintCustomerManagementApplication.class, args);

		CustomerUI customerUI = context.getBean(CustomerUI.class);
		customerUI.start();

		Log.debug("i am logged using debug level");
		Log.info("i am logged using info level");
		Log.error("i am logged using error level");

	}

}
