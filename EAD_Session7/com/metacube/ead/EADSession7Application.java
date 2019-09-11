package com.metacube.ead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class EAD Session7 Application ,is basically a go-through regarding IOC container 
 * and dependency injection of Spring boot , in this application we do dependency injection by
 * Annotation , Bean Qualifier and by Name as well and also by using JavaConfig class . 
 *   
 * @author Aman Gautam
 * 
 * Dated : 11/09/19
 */
@SpringBootApplication
public class EADSession7Application {
	
	/**
	 * Initialization of the main method.
	 *
	 * @param args
	 */
	public static void main(String [] args) {
		SpringApplication.run(EADSession7Application.class);
	}
}
