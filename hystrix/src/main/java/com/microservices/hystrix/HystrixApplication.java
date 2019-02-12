package com.microservices.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
public class HystrixApplication {

	
	/*
	* Hystrix is a Netflix tools to manage failover over the microservices
	* The microservices depend of other. Once a microservice service is down a contigency plan must happens
	* Hystrix helps to deal with this. Once a specific service is down, other could be down as well (since its dependency)
	* Or when a service is down, other services can run it up to cover the situation.
	* In addition, Hystrix offers a dashboard to manage all the current services.
	* 
	* At the HistryxController.java there is a service that depends from another service
	* Which means if the client is down the other service will the offline 
	* 
	* To deal with this situation, include the @EnabledCircuitBreaker at the Controller that calls the service
	* Then on the method that possible fails, include the annotation @HystrixCommand
	* 
	* parameters:
	* - faillbackMethod: a method on the class that is called when the request fails
	* 
	* The method must contain the same signature of the original method
	* 
	* 
	* Setting up Hystrix configurations:
	* At the @HistrixCommand there is a property commandProperties
	* where you can include all the properties:
	* @HystrixCommand(fallbackMethod = "defaultBehavior", commandProperties = {
	* 		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	* })
	* 
	* HystrixProperty is a pair value content.
	* execution.isolation.thread.timeoutInMilliseconds is the property name
	* All the properties can be found in: 
	* https://github.com/Netflix/Hystrix/wiki/Configuration
	* 
	* ---------------
	* For the Hystrix dashboard, you need to include the dependency:
	* 
	* 	<dependency>
	* 		<groupId>org.springframework.cloud</groupId>
	*		<artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
	*	</dependency>
	*
	* On the class, add the @EnableHystrix and the @EnableHystrixDashboard
	* Start the server(s)
	* 
	* Typing http://localhost:8889/hystrix.stream there is a lot of information (not easy to visualize)
	* Typing http://localhost:8889/hystrix you will enter on the dashboard
	* Include the http://localhost:8889/hystrix.stream on the input text and the dashboard will appear
	* 
	* Now you can call http://localhost:8889/your_service multiple times and it will be monitored by the dashboard
	* 
	* 
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(HystrixApplication.class, args);
	}
}
