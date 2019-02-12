package com.microservices.eurekaclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaClientController {

	@Autowired
    private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;
	

	@RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
	
	@RequestMapping("/getOtherServiceInfo")
	public String getOtherServiceInfo() {
		// note only the service name is used to invoke the request of the another client
		return this.restTemplate.getForObject("http://EUREKACLIENT/serviceInfo", String.class);
				
	}
}
