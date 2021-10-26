package com.cisco.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

public class InsertProductClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// scan for class with 6 sterotype annotations and create instances 
		ctx.scan("com.cisco.prj"); 
		ctx.refresh();
		
		OrderService service = ctx.getBean("orderService", OrderService.class);
		
		Product p = new Product(0, "iPhone 13", 120000.00, 500);
		service.addProduct(p);
		System.out.println("product added!!!");
	
	}

}
