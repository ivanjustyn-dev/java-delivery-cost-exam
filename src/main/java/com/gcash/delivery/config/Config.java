package com.gcash.delivery.config;

import org.springframework.boot.SpringBootConfiguration;

import jakarta.annotation.PostConstruct;

@SpringBootConfiguration
public class Config {
	
	@PostConstruct
	public void test() {
		System.out.println("Called");
	}

}
