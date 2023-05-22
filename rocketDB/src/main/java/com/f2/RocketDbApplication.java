package com.f2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import redis.clients.jedis.JedisPooled;

@SpringBootApplication
public class RocketDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketDbApplication.class, args);
	}
	
	@Bean
	JedisPooled jedisPooled() {
		return new JedisPooled("192.168.1.234", 6379, "pablo", "ciaogamer123");
	}

}
