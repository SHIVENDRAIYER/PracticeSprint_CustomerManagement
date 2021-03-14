package com.cg.practice.Sprint_CustomerManagement.itemms.dao;

import com.cg.practice.Sprint_CustomerManagement.itemms.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<Item,String> {

}
