package com.microservices.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

@SpringBootApplication
public class RibbonApplication {
	
	/*
	 * Ribbon is the library to create load balance on the client side application
	 * 
	 * To get start, you need to create a new class to setup the Ribbon configuration
	 * Then @Autowired the classc IClientConfig 
	 * Create a new @Bean
	 * public IPing ping(IClientConfig config) {
	 *  	return new PingUrl();
	 * }
	 * 
	 * And the @Bean
	 * public IRule rule(IClientConfig config) {
	 * 		return new AvailabilityFilteringRule();
	 * }
	 * 
	 * The bean above is just one of the implementation available to control the load balance.
	 * 
	 * On the applicaton properties:
	 * service name + ribbon.eureka.enable=false
	 * service name + ribbon.ServerListRefreshInterval=
	 * service name + ribbon.listOfServer=localhost:7777/ etc
	 * 
	 * example:
	 * ribbon-client:
 		ribbon:
  			eureka:
   				enable: false
  			ServerListRefreshInterval: 15000
  			listOfServers: localhost:8900,localhost:8901,localhost:8902
  			
  	 * Then set the annotation on the controller:
  	 * @RibbonClient(name="ribbon-client", configuration = RibbonConfiguration.class)
  	 * where name is the service indicated on the properties file and configration is the class created with the conf info
  	 * 
  	 * Then set the @LoadBalanced on the variable used to get the request (RestTemplate for example)
  	 * 
  	 * finally replace the service-name with the service indicated on the properties file:
  	 * this.restTemplate.getForObject("http://ribbon-client/execute", String.class);
  	 * Do not include the port
  	 * 
  	 * Note that every refresh a different service is called and the framework manages the best request automatically
  	 *  
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
}
