package com.microservices.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	/*
	 * Eureka is part of the Netflix framework for microservices
	 * Eureka is a catalog of all of the microservices registered
	 * To enable a project as eureka-server include the annotation @EnableEurekaServer at the top of the main class
	 * This provides all the configurations needed at the start
	 * 
	 * Then you go to the properties files and include the following:
	 * server.port=8761
	 * eureka.client.register-with-eureka=false
	 * eureka.client.fetch-registry=false
	 * 
	 * Finally browser to http://localhost:8761/ to check all the available information
	 * 
	 * --------------------------------
	 * 
	 * Now to replicate the eureka server and avoid one single point of failure.
	 * It provides a fail over in cause of any issues
	 * 
	 * To do it so, open up the c:\windows\system32\drivers\etc\hosts
	 * 
	 * Include all the domain that you wish
	 * e.g.:
	 * 127.0.0.1 localhost
	 * 127.0.0.1 localhost2
	 * 
	 * Then create the properties files associated with those hosts
	 * Also you need to include the properties
	 * eureka.instance.hostname=localhost
	 * eureka.client.serviceUrl.defaultZone=http://localhost2:8762/eureka
	 * 
	 * On the configuration, you need to include on the VM Arguments the active profile
	 * Eclipse: Run/Run Configurations / JRE / Click on the project then add the VM args
	 * 
	 * Start both servers then navigate to the root
	 * e.g.: localhost:8761
	 * Notice the DS Replicas: localhost2
	 * 
	 * 
	 * */
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
