package com.cisco.prj.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cisco.prj.service.EmailService;

@Configuration
public class MyConfig {
	
	// factory method
	@Bean
	public EmailService emailService() {
		return new EmailService("198.11.33.11", 21);
	}
}
