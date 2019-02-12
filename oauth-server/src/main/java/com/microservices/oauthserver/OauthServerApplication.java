package com.microservices.oauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class OauthServerApplication {

	/*
	 * Create a service security using OAuth protocol
	 * First thing to do is to include the @EnableAuthorizationServer
	 * Then you need to create a new class with the security configuration (extends AuthorizationServerConfigurerAdapter)
	 * Anote the new class as @Config and override the methods setting the proper configuration
	 * Then create a new class that extends to WebSecurityConfigurationAdapter
	 * Plus include the proper configuration on the new class
	 * 
	 * Running the app we can notice some endpoints on the log e.g.:{[/oauth/token]}
	 * On the postman, create a new post request 
	 * url: http://localhost:8907/oauth/token
	 * on Authorization tab create a new Basic Authorization
	 * Username and Password are mentoned on the AuthorizationServerConfig
	 * Clicking on the right side button "Update Request", now postman create a new Header
	 * The oauth requires the url param grant_type=password
	 * Others 2 params are user and password mentioned on the WebSecurityConfig
	 * */
	
	public static void main(String[] args) {
		SpringApplication.run(OauthServerApplication.class, args);
	}
}
