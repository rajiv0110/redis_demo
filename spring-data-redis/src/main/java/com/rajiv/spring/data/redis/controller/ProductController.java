package com.rajiv.spring.data.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajiv.spring.data.redis.entity.Product;
import com.rajiv.spring.data.redis.repository.ProductDao;

@RestController
@RequestMapping("/product")
@EnableCaching
public class ProductController {

	@Autowired
	private ProductDao dao;

	@PostMapping
	public Product save(@RequestBody Product product) {
		return dao.save(product);
	}

	@GetMapping
	public List<Product> getAllProduct() {
		return dao.findAll();
	}

	@GetMapping("/{id}")
	@Cacheable(key = "#id", value = "Product", unless = "#result.price >2")
	public Product findProduct(@PathVariable String id) {
		return dao.findProductById(id);
	}

}
