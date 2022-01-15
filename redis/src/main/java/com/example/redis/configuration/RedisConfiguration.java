package com.example.redis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.redis.model.Student;

@Configuration
public class RedisConfiguration {

	// Step 1: Redis Connection for database
	@Bean
	public RedisConnectionFactory connFac() {
		return new LettuceConnectionFactory();
	}

	// Step 2: Redis Template
	public RedisTemplate<String, Student> redisTemplate() {
		RedisTemplate<String, Student> template = new RedisTemplate<>();
		template.setConnectionFactory(connFac());
		return template;

	}
}
