package com.saman.tutorial.springactivemq.controller;

import com.saman.tutorial.springactivemq.model.Product;
import com.saman.tutorial.springactivemq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
public class ProductRest {

    @Autowired
    private ProductService service;

    @GetMapping(value = {"product/save"})
    public ResponseEntity save() {

        Product product = Product.builder()
                .name("Test Product")
                .quantity(1)
                .build();

        String productId = service.save(product);

        return ResponseEntity.ok().body(productId);
    }

    @GetMapping(value = {"product/find/all"})
    public Map<String, Product> findAll() {
        return service.findAll();
    }
}
