package com.saman.tutorial.springactivemq.service;

import com.saman.tutorial.springactivemq.model.Product;
import com.saman.tutorial.springactivemq.model.ProductStatus;
import com.saman.tutorial.springactivemq.util.BasicUtil;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service("productRepository")
public class ProductRepositoryImpl implements ProductRepository {

	private final Map<String, Product> storage = new ConcurrentHashMap<>();
	
	@Override
	public String save(Product product) {
		product.setId(BasicUtil.getUniqueId());
		product.setStatus(ProductStatus.CREATED);
		storage.put(product.getId(), product);

		return product.getId();
	}

	@Override
	public Product findById(String id) {
		return storage.get(id);
	}

	public Map<String, Product> findAll(){
		return storage;
	}
}
