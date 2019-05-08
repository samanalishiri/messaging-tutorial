package com.saman.tutorial.springactivemq.service;

import java.util.Map;

import com.saman.tutorial.springactivemq.model.Product;
import com.saman.tutorial.springactivemq.model.ProductStatus;
import com.saman.tutorial.springactivemq.messaging.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private ProductRepository repository;
	
	@Override
	public String save(Product model) {
		String id = repository.save(model);
		messageService.sendMessage(model);
		LOG.info("Application : sending product request {}", model);

		return id;
	}

	@Override
	public void updateStatus(String id, ProductStatus status) {
		Product product = repository.findById(id);
		product.setStatus(status);
		repository.save(product);
	}
	
	public Map<String, Product> findAll(){
		return repository.findAll();
	}

}
