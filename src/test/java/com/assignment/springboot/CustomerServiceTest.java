package com.assignment.springboot;

import com.assignment.springboot.models.Customer;
import com.assignment.springboot.repositories.ICustomerRepository;
import com.assignment.springboot.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private ICustomerRepository customerRepository;


    @Test
    public  void getAll(){

        Mockito.when( this.customerRepository.findAll()).thenReturn(null);
        Customer testCustomer1 = new Customer(0,"Dilara","Ece",7) ;
        Customer testCustomer2 = new Customer(0,"Mustafa","Aydar",36) ;
        List<Customer> customers = new ArrayList<>();
        customers.add(testCustomer1);
        customers.add(testCustomer2);
        customerService.saveCustomer(testCustomer1);
        customerService.saveCustomer(testCustomer2);

        Assertions.assertEquals(2,customers.size());
        Assertions.assertEquals(7,customers.get(0).getAge());
    }
}
