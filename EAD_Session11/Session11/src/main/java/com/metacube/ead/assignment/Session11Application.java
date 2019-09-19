package com.metacube.ead.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


/**
 * The Class Session11Application is application which go through 
 * the concept on integration of spring boot to hibernate (Shortning our task to write queries).
 * 
 * @author Aman Gautam
 * 
 * Dated :18/9/19
 */
@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class Session11Application {

	/**
	 * Initialization of the Application via main method
	 *
	 * @param args 
	 */
	public static void main(String[] args) {
		SpringApplication.run(Session11Application.class, args);
	}

}
