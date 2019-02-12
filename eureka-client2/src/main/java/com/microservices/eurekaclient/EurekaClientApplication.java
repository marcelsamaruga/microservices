package com.microservices.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

	/*
	 * notes on the EurekaClient2Controller.java
	 * */
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
