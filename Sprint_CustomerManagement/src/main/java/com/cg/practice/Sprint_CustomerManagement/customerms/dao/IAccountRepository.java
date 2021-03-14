package com.cg.practice.Sprint_CustomerManagement.customerms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.practice.Sprint_CustomerManagement.customerms.entities.*;

public interface IAccountRepository extends JpaRepository<Account,Long> {
	
	

}
