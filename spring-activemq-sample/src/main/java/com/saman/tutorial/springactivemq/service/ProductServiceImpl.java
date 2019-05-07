package com.saman.tutorial.springactivemq.service;

import java.util.Map;

import com.saman.tutorial.springactivemq.model.MessageModel;
import com.saman.tutorial.springactivemq.model.Product;
import com.saman.tutorial.springactivemq.model.ProductStatus;
import com.saman.tutorial.springactivemq.messaging.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("productService")
public class ProductServiceImpl implements ProductService {

	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private MessageSender messageSender;
	
	@Autowired
	private ProductRepository repository;
	
	@Override
	public void save(Product model) {
		repository.save(model);
		messageSender.sendMessage(model);
		LOG.info("Application : sending product request {}", model);
	}

	@Override
	public void update(MessageModel model) {
		Product product = repository.findById(model.getProductId());
		product.setStatus(ProductStatus.getByCode(model.getReturnCode()));
		repository.save(product);
	}
	
	public Map<String, Product> findAll(){
		return repository.findAll();
	}

}
