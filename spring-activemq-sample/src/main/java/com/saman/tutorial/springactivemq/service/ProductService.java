package com.saman.tutorial.springactivemq.service;

import com.saman.tutorial.springactivemq.model.MessageModel;
import com.saman.tutorial.springactivemq.model.Product;

import java.util.Map;

public interface ProductService {

	void save(Product model);
	
	void update(MessageModel model);
	
	Map<String, Product> findAll();
}
