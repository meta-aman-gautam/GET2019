package com.example.demo;
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
 * The SpringSecurityApplication is an application which is used to 
 * go through the Spring security concepts and how it integrates with the spring boot 
 * 
 * @author Aman Gautam
 * 
 * Dated:23/9/19
 */
@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class SpringSecurityApplication extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {

    /**
     * The Initialization of the application via main method.
     *
     * @param arg
     */
    public static void main(final String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

  
    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(SpringSecurityApplication.class);
    }
}