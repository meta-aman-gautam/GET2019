package com.metacube.ead.springSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * The Class Application is extension of the Spring Security application .
 * its just uses the Hibernate template in place of Jbdc template and enables 
 * security through it.
 * 
 * @author Aman Gautam
 * 
 * Dated:23/9/19
 */
@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class Application extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {

    /**
     * The Initialization of the application via main method.
     *
     * @param args 
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * SpringBootServletInitializer is used to manually configure the spring security 
     * and provide a configuration  
     * 
     */
    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}