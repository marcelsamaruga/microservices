package com.microservices.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

	/*
	 * Zuul works like a proxy/gateway between the microservices
	 * 
	 * Once a request comes from any client the Zuul will take it and delegates
	 * 
	 * The first thing to do is to add the @EnableZuulProxy on the Zuul Proxy
	 * Then include the following options on the application properties
	 * ribbon.eureka.enabled=false
	 * And zuul.routes.thePathYouWant.url=http://localhost:8905
	 * where thePathYouWant is any string that you wish and localhost:8905 is the client to be consumed
	 * 
	 * zuul.routes.thePathYouWant.path=/anyPath/**
	 * where path is the shortcurt to the url 
	 * 
	 * e.g.: http://localhost:8906/anyPath/execute
	 * 
	 * ******
	 * Zuul Filter
	 * A new class to extends ZuulFilter:
	 * method shouldFilter tells if the filter is enabled or not
	 * method filterOrder tells the order of the filters (it may have multiples Zuul filters)
	 * method filterType return "pre" (before running), "rounding" (running), "post" (after running)
	 * method run is the execution itself
	 * 
	 * Finally you can create a Bean with the new Filter
	 * */
	
	@Bean
	public ZuulFilterPre filter() {
		return new ZuulFilterPre();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
