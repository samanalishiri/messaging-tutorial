package com.saman.tutorial.springactivemq.service;

import com.saman.tutorial.springactivemq.model.Product;
import com.saman.tutorial.springactivemq.model.ProductStatus;

import java.util.Map;

public interface ProductService {

	String save(Product model);

	void updateStatus(String id, ProductStatus status);
	
	Map<String, Product> findAll();
}
