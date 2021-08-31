//package com.assignment.springboot.repositories;
//
//import com.assignment.springboot.models.Customer;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Repository
//public class CustomerRepository implements ICustomerRepository{
//
//    private List<Customer> customers = new ArrayList<>(Arrays.asList(
//            (new Customer(0, "Dilara", "ECE", 7)),
//            new Customer(0, "Ece", "AYDAR", 12)));
//
//
//    @Override
//    public Customer saveCustomer(Customer customer) {
//        customers.add(customer);
//        return customer;
//    }
//
//    @Override
//    public Customer getCustomerById(int id) {
//        for (Customer customer: customers ) {
//            if(customer.getId() == id){
//                return customer;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Customer> getCustomers() {
//        return customers;
//    }
//
//    @Override
//    public void deleteCustomer(int id) {
//        for (Customer customer:customers ) {
//            if(customer.getId() == id){
//                customers.remove(id);
//                break;
//            }
//        }
//    }
//
//    public Customer updateCustomer(Customer customer){
//        Customer tempCustomer = getCustomerById(customer.getId());
//        if(tempCustomer==null){
//            return null;
//        }
//        tempCustomer.setFirstName(customer.getFirstName());
//        return tempCustomer;
//
//    }
//
//
//}
