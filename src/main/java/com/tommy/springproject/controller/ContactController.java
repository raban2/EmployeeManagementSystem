package com.tommy.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tommy.springproject.utils.MailUtils;

@Controller
public class ContactController {
	
	@Autowired   //creating bean of mailutil class
	private MailUtils mailUtil;
	
	@GetMapping("/contact")
	public String getContact() {
		return "ContactForm";
	}
	
	
	//Capturing
	@PostMapping("/contact")
	public String postContact(@RequestParam String toEmail,@RequestParam String subject,@RequestParam String message) {
		mailUtil.sendEmail(toEmail, subject, message);  //controller calls the sendEmail method to send the email using the three parameters
		return "ContactForm";
	}
	
	

}
