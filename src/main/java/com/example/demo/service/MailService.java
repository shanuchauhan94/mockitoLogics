package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class MailService {

	public static String sendEmail(int userId) {
		if(userId != 0)
		  return "Email Send Successfully";
		else
			return "Email Operation Failed.";
	}
	
	
}
