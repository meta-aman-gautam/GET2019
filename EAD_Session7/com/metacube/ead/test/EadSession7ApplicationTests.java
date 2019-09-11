package com.metacube.assignment;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.metacube.ead.service.MailSender;
import com.metacube.ead.service.implementation.MockMailSender;
import com.metacube.ead.service.implementation.SmtpMailSender;

/**
 * Test class for EAD Session 7 implementations 
 * 
 * @author Aman Gautam
 * 
 * Dated : 11/9/19
 *
 */
public class EadSession7ApplicationTests {

	@Autowired
	private MailSender mailSender ;
	
	private void dummyTypeConstructor(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	private void dummyTypeSetter(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	/**
	 * test for Setter Injection (dummy Constructor used)
	 */
	@Test
	public void testForDummyTypeConstructorInjection(){
		
		MailSender mailSender = new MockMailSender();
		dummyTypeConstructor(mailSender);
		assertEquals(mailSender.sendMail().toString(), "Sending Mock Mail on console ->");
		
		MailSender mailSenderSmtp = new SmtpMailSender();
		dummyTypeConstructor(mailSenderSmtp);
		assertEquals(mailSenderSmtp.sendMail().toString(), "Sending Simple Mail Via SMTP");
	}
	
	/**
	 * test for Setter Injection (dummy setter used)
	 */
	@Test
	public void testdummyTypeSetterInjection(){
		
		MailSender mailSender = new MockMailSender();
		dummyTypeSetter(mailSender);
		assertEquals(mailSender.sendMail().toString(), "Sending Mock Mail on console ->");
		
		MailSender mailSenderSmtp = new SmtpMailSender();
		dummyTypeSetter(mailSenderSmtp);
		assertEquals(mailSenderSmtp.sendMail().toString(), "Sending Simple Mail Via SMTP");
	}
}