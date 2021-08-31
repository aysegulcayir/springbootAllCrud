package com.assignment.springboot.repositories;

import com.assignment.springboot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository  extends CrudRepository<Product, Integer> {

    Product getProductById(long id);


}
