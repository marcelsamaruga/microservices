package com.oreilly.cloud;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class DemoConfiguration {

	@Bean
	public List<String> cats(){
		return Arrays.asList("Bengal", "Lion");
	}
	
}
