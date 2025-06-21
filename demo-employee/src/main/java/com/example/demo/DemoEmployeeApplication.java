package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@ComponentScan(basePackages = "com.example.controller")
@SpringBootApplication
public class DemoEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEmployeeApplication.class, args);
	}

}
