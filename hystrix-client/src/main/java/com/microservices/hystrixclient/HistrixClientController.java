package com.microservices.hystrixclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistrixClientController {

	@RequestMapping("/execute")
	public List<String> execute() {
		return Arrays.asList("Done", "Pending", "Cancelled");
	}
	
}
