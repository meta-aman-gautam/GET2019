package com.metacube.ead.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.ead.service.implementation.MockMailSender;
import com.metacube.ead.service.implementation.SmtpMailSender;

/**
 * The Class JavaConfig is basically used to set the configuration
 * of the user defined Bean in the IOC container 
 * 
 * @author Aman Gautam
 * 
 * Dated :11/9/19.
 */
@Configuration
@ComponentScan(basePackages = "com.metacube.ead")
public class JavaConfig {

//  @Qualifier("smtp")
//	@Primary
//	@Bean
//	public SmtpMailSender getSmtpMailSender(){
//		SmtpMailSender smtpMailSender = new SmtpMailSender();
//		return smtpMailSender ;
//	}
//	
//	@Qualifier("mockmail")
//	@Primary
//	@Bean
//	public MockMailSender getMockMailSender(){
//		MockMailSender mockMailSender = new MockMailSender();
//		return mockMailSender;
//
//	}
}
