package com.rajiv.spring.data.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.rajiv.spring.data.redis.entity.Product;

@Repository
public class ProductDao {

	public static final String HASH_KEY = "Product";

	@Autowired
	private RedisTemplate template;

	public Product save(Product product) {
		template.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;

	}

	public List<Product> findAll() {
		return template.opsForHash().values(HASH_KEY);
	}

	public Product findProductById(String id) {
		System.out.println("data fetced from database");
		return (Product) template.opsForHash().get(HASH_KEY, id);
	}

}
