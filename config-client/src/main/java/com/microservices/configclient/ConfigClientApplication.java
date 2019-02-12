package com.microservices.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClientApplication {
	
	/*
	 * For the Config Client reaches the Config Server project, you need to include the bootstrap.yaml file at the resources
	 * At the bootstrap.yaml include the some properties:
	 *  - spring.profiles = you need to check the file name on the config server
	 *  - spring.application.name = you need to check the file name of the properties/yaml file on the config server (do not include the profile)
	 *  - spring.cloud.config.uri = the url of the config server
	 * The bootstrap.yaml file is loaded before the application file then the properties are loaded earlier and inject in the project
	 * 
	 * ---------
	 * The @RefreshScope annotation allows the server application to retrieve the values from the properties file without be refreshed
	 * Note the git repository files must be commited
	 * After the file on the stash, then ping the refresh actuator endpoint with a post method. e.g.:
	 * curl -H "Content-Type: application/json" --data '{}' http://localhost:8000/actuator/refresh
	 * 
	 * To do it so, you must to enable refresh actuator endpoint:
	 * management: endpoints: web: exposure: include: "*"
	 * if the file is properties instead of yml, do not include "*" (only *)
	 * 
	 * Note the @RefreshScope must be in the class that contains the @Value annotation
	 * 
	 * ---------
	 * 
	 * Encryption
	 * Download the JCE for your Java version and replace the downloaded files to the folder:
	 * C:/Program Files/Java/jre1.8.0_151/lib/security/policy/unlimited
	 * 
	 * Now on the application file of the config-server include the encrypt.key=YOUR_PUBLIC_KEY
	 * 
	 * Make a call to curl http://localhost:8888/encrypt -d Value to be encrypted
	 * Usually the value to be encrypted is the value from the git repository (properties file)
	 * Copy the result and replace on the git repo (properties file)
	 * e.g.:
	 * password=abcd
	 * 
	 * curl http://localhost:8888/encrypt -d abcd
	 * result: qazwsxcderfvg (copy it)
	 * 
	 * on the properties file replace
	 * password={cipher}qazwsxcderfvg
	 * 
	 * */

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

}
