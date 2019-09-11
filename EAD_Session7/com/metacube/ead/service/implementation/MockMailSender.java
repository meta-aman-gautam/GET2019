package com.metacube.ead.service.implementation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.ead.service.MailSender;

/**
 * Implementation of the MailSender method sendMail is class MockMailSender
 * 
 * @author Aman Gautam 
 * 
 * Dated: 11/9/19
 *
 */
@Qualifier("mockmail")
@Primary
@Component
public class MockMailSender implements MailSender {

	@Override
	public String sendMail() {
		System.out.println("Sending Mock Mail on console ->");
		return "Sending Mock Mail on console ->";
	}
}
