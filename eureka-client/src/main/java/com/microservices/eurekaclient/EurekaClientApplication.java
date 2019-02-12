package com.microservices.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

	/*
	 * Once the Eureka Servers are running, you need to create a new microservice project and include the @EnableEurekaClient
	 * It's recommended to include a spring application name on the properties file
	 * 
	 * Now, the client is up, to go the eureka server url and notice the services was registered:
	 * Instances currently registered with Eureka:
	 * Application	AMIs	Availability Zones	Status
	 * A-BOOTIFUL-CLIENT	n/a (1)	(1)	UP (1) - DESKTOP-OOSTLJ9:a-bootiful-client
	 * 
	 * Do not forget to register the client name at the bootstrap.properties file as
	 * spring.application.name=
	 * 
	 * */
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	

	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
