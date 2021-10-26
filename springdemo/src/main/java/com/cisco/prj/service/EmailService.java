package com.cisco.prj.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	private String ip;
	private int port;

	public EmailService(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void sendEmail(String msg) {
		System.out.println("Email " + msg + "sent to " + ip + ":" + port);
	}
}
