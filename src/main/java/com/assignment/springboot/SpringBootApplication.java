package com.assignment.springboot;

import com.assignment.springboot.models.Customer;
import com.assignment.springboot.models.NewOrder;
import com.assignment.springboot.models.Product;
import com.assignment.springboot.repositories.ICustomerRepository;
import com.assignment.springboot.repositories.IOrderRepository;
import com.assignment.springboot.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableJpaRepositories( basePackages = "com.assignment.springboot")
@ComponentScan( basePackages = "com.assignment.springboot")
public class SpringBootApplication implements CommandLineRunner {
	ICustomerRepository customerRepository;
	IOrderRepository orderRepository;
	IProductRepository productRepository;
	private LocalDateTime orderDate;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args); }

	@Autowired
	public SpringBootApplication(ICustomerRepository customerRepository,
								 IOrderRepository orderRepository,
								 IProductRepository productRepository){

		this.customerRepository = customerRepository;
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;

	}

	@Override
	public void run(String... args) throws Exception {

		// create objects and store them
		// order matters
		// id are created by the database
		Customer customer = new Customer(0,"Jan","Klaassen",35);
		Customer customerCreated = customerRepository.save(customer);
		Customer customer1 = new Customer(0,"rick","artz",30);
		Customer customerCreated1 = customerRepository.save(customer1);
		List<Product> products = new ArrayList<>();
		Product product;
		product = new Product(0,"Jason","Book");
		productRepository.save(product);
		products.add(product);
		// order will now have

		NewOrder order = new NewOrder(0,"First webOrder",customerCreated,products, orderDate);

		orderRepository.save(order);

	}
}
