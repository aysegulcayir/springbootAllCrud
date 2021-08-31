package com.assignment.springboot.controllers;

import com.assignment.springboot.models.NewOrder;
import com.assignment.springboot.repositories.ICustomerRepository;
import com.assignment.springboot.repositories.IOrderRepository;
import com.assignment.springboot.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    OrderService orderService;

    @GetMapping("/allorder")
    public Iterable<NewOrder> getAllOrders() {
//        return this.orderRepository.findAll();
        return this.orderService.getAllOrders();
    }

    @PostMapping("/neworder")
    public NewOrder saveNewOrder(@RequestBody NewOrder order) {

        return this.orderService.saveNewOrder(order);
    }

    @PutMapping("/update/customer")
    public void updateOrder(@RequestBody NewOrder changeOrder) {

        this.orderService.updateOrder(changeOrder);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {

        this.orderService.deleteOrder(id);
    }



}
