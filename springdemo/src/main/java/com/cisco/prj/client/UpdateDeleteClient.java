package com.cisco.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

public class UpdateDeleteClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.cisco.prj"); 
		ctx.refresh();
		
		OrderService service = ctx.getBean("orderService", OrderService.class);
		
		Product p = new Product(2,"Logitech Mouse", 650, 100);
		
		service.updateProduct(p);
		
	}

}
