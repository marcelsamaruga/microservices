package com.microservices.zuulclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulClientController {

	@RequestMapping("/execute")
	public String execute() {
		return "Hello Zuul Client";
	}
	
}
