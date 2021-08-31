package com.assignment.springboot.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class NewOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private LocalDateTime orderDate;



    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToMany
    List<Product> products;

    public NewOrder() {
    }

    public NewOrder(long id, String description, Customer customer, List<Product> products, LocalDateTime orderDate) {
        this.id = id;
        this.description = description;
        this.customer = customer;
        this.products = products;
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}




