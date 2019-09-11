package com.metacube.ead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.ead.service.MailSender;

/**
 * The Class TestController. which has the most important method to 
 * do dependency injection .
 * 
 * @author Aman Gautam
 * 
 * Dated 11/9/19
 */
@RestController
public class TestController {

	private MailSender mailSender ;

	/**
	 * Getter method for the dependency( mailSender )
	 *
	 * @return mailSender
	 */
	public MailSender getMailSender() {
		return mailSender;
	}
	
	/*
	 * Setter injection by Name .
	 */
//	public void setMailSender(MailSender mockMailSender) {
//		this.mailSender = mailSender;
//	} 
//	
//	public void setMailSender(MailSender smtpMailSender) {
//		this.mailSender = mailSender;
//	}

	
	/*
	 * Setter injection with primary annotation
	 */
//	
//	public void setMailSender(MailSender mailSender) {
//		this.mailSender = mailSender;
//	} 
//	
//
//	public void setMailSender(MailSender mailSender) {
//		this.mailSender = mailSender;
//	}
	

	/*
	 * Setter injection with Bean Qualifier
	 */
//	
//	public void setMailSender(@Qualifier("smtp") MailSender mailSender) {
//		this.mailSender = mailSender;
//	} 
	
//	
//	public void setMailSender(@Qualifier("mockmail") MailSender mailSender) {
//		this.mailSender = mailSender;
//	}

	/*
	 * Constructor injection by Name .
	 */
//	public TestController(MailSender mockMailSender) {
//		this.mailSender = mockMailSender;
//	}
//	
//	public TestController(MailSender smtpMailSender) {
//		this.mailSender = smtpMailSender;
//	}
	
	
	/*
	 * Constructor injection by Primary annotation .
	 */
//	public TestController(MailSender mailSender) {
//		this.mailSender = mailSender;
//	}
	
//	public TestController(MailSender mailSender) {
//		this.mailSender = mailSender;
//	}
	
	
	/*
	 *  Constructor injection by Bean Qualifier .
	 */
//	public TestController(@Qualifier("smtp") MailSender mailSender) {
//		this.mailSender = mailSender;
//	}
	
//	public TestController(@Qualifier("mockmail")MailSender mailSender) {
//		this.mailSender = mailSender;
//	}


	/**
	 * Method which is mapped to the url of the local host
	 * sendsMail() method returns the implementation of the interface MailMethod .
	 *
	 * @return string 
	 */
	@RequestMapping("/send")
	public String sendsMail(){
		return mailSender.sendMail();
	}
}


