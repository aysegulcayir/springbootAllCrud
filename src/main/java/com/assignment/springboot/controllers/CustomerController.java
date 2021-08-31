package com.assignment.springboot.controllers;

import com.assignment.springboot.exceptions.AlreadyExist;
import com.assignment.springboot.exceptions.NotFoundException;
import com.assignment.springboot.models.Customer;
//import com.assignment.springboot.repositories.CustomerRepository;
import com.assignment.springboot.repositories.ICustomerRepository;
import com.assignment.springboot.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Optional;

@CrossOrigin("**")
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    CustomerService customerService;


    @GetMapping("/customers")
    public Iterable<Customer> getCustomers() {
//        return this.customerRepository.getCustomers();
        return this.customerService.getAll();
    }

    @GetMapping("/customerbyid/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
//        return this.customerRepository.getCustomerById(id);
        Optional<Customer> customer = this.customerRepository.findById(id);
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);

    }

    @GetMapping("/customerbyid2/")
    public Customer getCustomerById2(@RequestParam long id) {

        //return this.customerRepository.getCustomerById(id);
        Optional<Customer> customer = this.customerRepository.findById(id);
        return customer.get();
    }

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer) throws ResponseStatusException {
//        this.customerRepository.saveCustomer(customer);
        if (this.customerRepository.existsById(customer.getId())) {throw new AlreadyExist();}
        this.customerService.saveCustomer(customer);
        return customer;
//        try {
//             this.customerService.saveCustomer(customer);
//        } catch (ResponseStatusException e) {
//            throw new AlreadyExist();
//        }
//        return  customer;

    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable long id) {

        //this.customerRepository.deleteCustomer(id);
        Optional<Customer> customer = this.customerRepository.findById(id);

       // if (customer.isEmpty()) throw new NotFoundException();

        this.customerRepository.delete(customer.get());

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        //return this.customerRepository.updateCustomer(customer);

        Optional<Customer> tempCustomer = this.customerRepository.findById(customer.getId());
        if (tempCustomer == null) {
            throw new NotFoundException();
        } else {

            tempCustomer.get().setId(customer.getId());
            this.customerRepository.save(tempCustomer.get());
        }

        return new ResponseEntity<>(tempCustomer.get(), HttpStatus.OK);

    }

    @GetMapping("/underage")
    public Iterable<Customer> getUnderage() {
        //Iterable<Customer> customers = this.customerRepository.findAllByAgeLessThan(18);
        Iterable<Customer> customers = this.customerService.getUnderage();
        return customers;
    }

    @GetMapping("/countoforders/id")
    public int AmountOfGetOrders(@PathVariable long id) {
        //Iterable<Customer> customers = this.customerRepository.findAllByAgeLessThan(18);
       int amountOfOrders = this.customerService.getAllOrdersOfCustomer(id);
        return amountOfOrders;
    }


//    @DeleteMapping("/delete/{id}")
//    public Boolean delete(@PathVariable int id) {
//        this.customerService.deleteById(id);
//        return Boolean.TRUE;
//    }

}

