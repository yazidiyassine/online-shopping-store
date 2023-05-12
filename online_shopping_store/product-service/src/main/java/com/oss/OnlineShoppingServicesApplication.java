package com.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OnlineShoppingServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingServicesApplication.class, args);
	}

}
