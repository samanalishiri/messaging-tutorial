package com.saman.tutorial.springactivemq.service;

import com.saman.tutorial.springactivemq.model.Product;

import java.util.Map;

public interface ProductRepository {

    void save(Product product);

    Product findById(String id);

    Map<String, Product> findAll();
}
