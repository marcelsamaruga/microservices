package com.microservices.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServiceApplication {

	/*
	 * The configuration server includes commons variable from different projects
	 * The goal is to manager and to keep easier to deal with multiple projects
	 * At the application file you can set a git repository where another application files are included
	 * At the repository there is one application file for each project managed by the config-server project
	 * Once you add/update the repository is changed there is no need to refresh/reboot the config application
	 * 
	 * */
	
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigServiceApplication.class, args);
	}
}
