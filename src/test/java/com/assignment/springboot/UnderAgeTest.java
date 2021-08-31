package com.assignment.springboot;

import com.assignment.springboot.controllers.CustomerController;
import com.assignment.springboot.models.Customer;
import com.assignment.springboot.repositories.ICustomerRepository;
import com.assignment.springboot.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
//@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class UnderAgeTest {

    @Mock
    ICustomerRepository mockedService;


    @InjectMocks
    CustomerService customerService;

    @Test
    public void underAge(){
        Customer testCustomer1 = new Customer(0,"Dilara","Ece",7) ;
        Customer testCustomer2 = new Customer(0,"Mustafa","Aydar",36) ;
        List<Customer> customers = new ArrayList<>();
        customers.add(testCustomer1);
        customers.add(testCustomer2);
        customerService.saveCustomer(testCustomer1);
        customerService.saveCustomer(testCustomer2);
        when(mockedService.findKids(18)).thenReturn(Collections.singleton(testCustomer1));
        Iterable<Customer> customersValues = customerService.getUnderage();
        Assertions.assertEquals(Collections.singleton(testCustomer1),customersValues);
    }
}
