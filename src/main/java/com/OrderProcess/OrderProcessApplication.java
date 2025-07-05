package com.OrderProcess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrderProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProcessApplication.class, args);
	}

}