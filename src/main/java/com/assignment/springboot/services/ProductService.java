package com.assignment.springboot.services;

import com.assignment.springboot.models.Product;
import com.assignment.springboot.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    public Product getProductById(long id) {

        return productRepository.getProductById(id);

    }
}
