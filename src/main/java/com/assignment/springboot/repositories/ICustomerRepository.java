package com.assignment.springboot.repositories;

import com.assignment.springboot.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Long> {
//    Customer saveCustomer(Customer customer);
//    List<Customer> getCustomers();
//    void deleteCustomer(int id);
//    Customer updateCustomer(Customer customer);
//    Customer getCustomerById(int id);

    @Query("SELECT c FROM Customer c WHERE c.age<18 ")//? varsa ben deger gonderiyorum
    Iterable<Customer> findKids(int age);
    @Query("SELECT COUNT(*) FROM NewOrder as no WHERE no.customer.id<?1 ")//? varsa ben deger gonderiyorum
    int getNumberOfOrder(long id);
}
