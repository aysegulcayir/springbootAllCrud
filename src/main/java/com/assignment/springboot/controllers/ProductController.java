package com.assignment.springboot.controllers;

import com.assignment.springboot.models.Product;
import com.assignment.springboot.repositories.IProductRepository;
import com.assignment.springboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id", required = true) long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
