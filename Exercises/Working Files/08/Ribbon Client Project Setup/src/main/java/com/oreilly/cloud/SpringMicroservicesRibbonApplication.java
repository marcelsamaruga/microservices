package com.oreilly.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SpringMicroservicesRibbonApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Autowired
	public RestTemplate restTemplate;
	
	@RequestMapping("/startClient")
	public String startClient(){
		return this.restTemplate.getForObject("http://localhost:7777/execute", String.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesRibbonApplication.class, args);
	}
}
