package com.rajiv.spring.data.redis.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 7156526077883281623L;

	@Id
	private String id;
	private String name;
	private int qty;
	private long price;

}
