package com.microservices.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

/*
 * The EurekaClient lib gets info about all other services
 * */

@RestController
public class EurekaClient2Controller {

	// eureka client gets all the service information available on the eureka discovery lib
	@Autowired
	private EurekaClient eurekaClient;
	
	@RequestMapping("/serviceInfo")
	public String getServiceInfo() {
		// where a-bootiful-client is the name of the other eureka client (spring.application.name)
		// 
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("eurekaclient2", false);
		return instanceInfo.getAppName() + " - " + instanceInfo.getHostName() + " - " +
		instanceInfo.getIPAddr() + " - " + instanceInfo.getPort() + " - " + 
		instanceInfo.getStatus() + " - " + instanceInfo.getHomePageUrl();
	}
	
	
	
}
