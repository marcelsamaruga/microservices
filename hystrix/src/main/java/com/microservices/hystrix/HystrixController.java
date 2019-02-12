package com.microservices.hystrix;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@EnableHystrix
@EnableHystrixDashboard
public class HystrixController {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/start")
	@HystrixCommand(fallbackMethod = "defaultBehavior" /* where defaultBehavior is a method on this class*/)
	public List<String> get() {
		return this.restTemplate.getForObject("http://localhost:8888/execute", List.class);
	}
	
	public List<String> defaultBehavior() {
		return Arrays.asList("The service is offline.");
	}

	
	/*
	 * Setting up Hystrix configurations:
	 * */
	@RequestMapping("/start2")
	@HystrixCommand(fallbackMethod = "defaultBehavior2", commandProperties = {
			// non response until 500 milliseconds then call the failover method
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500") 
	})
	public List<String> get2(@RequestParam long time) throws InterruptedException {
		Thread.sleep(time);
		return this.restTemplate.getForObject("http://localhost:8888/execute", List.class);
	}
	
	// the method must have the same signature of get2
	public List<String> defaultBehavior2(long time) {
		return Arrays.asList("The service is offline.");
	}
}
