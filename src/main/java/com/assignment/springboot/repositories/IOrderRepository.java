package com.assignment.springboot.repositories;

import com.assignment.springboot.models.Customer;
import com.assignment.springboot.models.NewOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.springboot.models.NewOrder;

@Repository
public interface IOrderRepository extends CrudRepository<NewOrder,Long> {

}
