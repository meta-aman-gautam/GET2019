package com.metacube.ead.service.implementation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.ead.service.MailSender;

/**
 * Implementation of the MailSender method sendMail is class SmtpMailSender
 * 
 * @author Aman Gautam
 * 
 * Dated :11/9/19
 *
 */
@Primary
@Qualifier("smtp")
@Component
public class SmtpMailSender implements MailSender{

	@Override
	public String sendMail() {
		return "Sending Simple Mail Via SMTP";
	}
}
