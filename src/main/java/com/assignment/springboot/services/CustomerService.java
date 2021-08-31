package com.assignment.springboot.services;

import com.assignment.springboot.exceptions.BadRequestExceptions;
import com.assignment.springboot.exceptions.NotFoundException;
import com.assignment.springboot.models.Customer;
import com.assignment.springboot.models.NewOrder;
import com.assignment.springboot.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    public Iterable<Customer> getAll(){
        return this.customerRepository.findAll();
    }


    public Customer saveCustomer( Customer customer) throws ResponseStatusException {
        if (customer.getFirstName().equals("") ||customer.getLastName().equals("")) {

             throw new BadRequestExceptions();

        }

        return this.customerRepository.save(customer);
    }

    public Iterable<Customer> getUnderage (){
        //Iterable<Customer> customers = this.customerRepository.findAllByAgeLessThan(18);
        Iterable<Customer>  customers = this.customerRepository.findKids(18);
        return customers;
    }
    public void deleteById(int id) {

    }
    public int getAllOrdersOfCustomer(long id){
        return this.customerRepository.getNumberOfOrder(id);
    }

}
