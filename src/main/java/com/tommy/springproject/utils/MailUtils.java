package com.tommy.springproject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/*
 * Java Mail Sender Dependency is added in this project 
 */

@Component // creates beans //calls in first
public class MailUtils {
	
	@Autowired
	private JavaMailSender javaMailSender;    //Inject this dependency

	// invoked this method when sendMail is called
	public void sendEmail(String toEmail, String subject, String message) {
		
		//Create object 
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(toEmail);
		mail.setSubject(subject);
		mail.setText(message);
		
		//Send the mail
		javaMailSender.send(mail);
		
		
		//Now go to Application.properties to add who sends the mail

	}

}
