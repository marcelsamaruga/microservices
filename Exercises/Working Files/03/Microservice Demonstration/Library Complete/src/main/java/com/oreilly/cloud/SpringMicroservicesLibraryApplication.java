package com.oreilly.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;

@SpringBootApplication
public class SpringMicroservicesLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesLibraryApplication.class, args);
	}
}
