package com.microservices.ribbonclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonClientController {

	@Value("${server.port}") // this content is on the VMArgs
	public String port;
	
	@RequestMapping("/execute")
	public String execute( ) {
		return "Hello world: " + this.port;
	}
	
	@RequestMapping("/")
	public String up() {
		return "Up";
	}
}
