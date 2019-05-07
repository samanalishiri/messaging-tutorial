package com.saman.tutorial.springactivemq.controller;

import javax.validation.Valid;

import com.saman.tutorial.springactivemq.model.Product;
import com.saman.tutorial.springactivemq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping(value = { "/", "/home" })
	public String viewOrderPageHome() {
		return "index";
	}

	@GetMapping(value = { "product/save" })
	public String viewOrderPage(ModelMap model) {
		model.addAttribute("model", new Product());
		return "save";
	}

	@PostMapping(value = { "product/save" })
	public String save(@ModelAttribute Product product, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "save";
		}
		service.save(product);
		model.addAttribute("message", String.format("Product %s registered.", product.getName()));
		return "success";
	}
	
	@GetMapping(value = { "product/find/all" })
	public String findAll(ModelMap model) {
		model.addAttribute("collection", service.findAll());
		return "product";
	}
}
