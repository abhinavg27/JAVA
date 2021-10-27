package com.cisco.prj.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.cisco.prj.service.EmailService;

@Configuration
public class MyConfig {
	
	// factory method
	@Bean
	public EmailService emailService() {
		return new EmailService("198.11.33.11", 21);
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
			ms.setBasename("messages");
		return ms;
	}
}
