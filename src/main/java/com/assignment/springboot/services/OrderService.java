package com.assignment.springboot.services;

import com.assignment.springboot.exceptions.NotFoundException;
import com.assignment.springboot.models.Customer;
import com.assignment.springboot.models.NewOrder;
import com.assignment.springboot.repositories.ICustomerRepository;
import com.assignment.springboot.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    ICustomerRepository customerRepository;
    private NotFoundException notFoundException;


    public NewOrder saveNewOrder(NewOrder order) {

        //checking if the customer exists
        Customer customer = order.getCustomer();
        if (customer != null) {
            if (this.customerRepository.existsById(customer.getId())) {

                return this.orderRepository.save(order);

            }

            throw new NotFoundException();
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND
//            );
        }
        return null;
    }

    public Iterable<NewOrder> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public void updateOrder(NewOrder order) {
        Optional<NewOrder> tempOrder = this.orderRepository.findById(order.getId());
        if (tempOrder.isEmpty()) {
            throw new NotFoundException();
        }
        tempOrder.get().setCustomer(order.getCustomer());
        this.orderRepository.save(tempOrder.get());

    }

    public void deleteOrder(Long id) {
        Optional<NewOrder> order = this.orderRepository.findById(id);
        if (order.isEmpty())
            System.out.println(notFoundException + " No order exists.");
        this.orderRepository.delete(order.get());
    }

}
