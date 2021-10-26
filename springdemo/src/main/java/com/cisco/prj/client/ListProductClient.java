package com.cisco.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

public class ListProductClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// scan for class with 6 sterotype annotations and create instances 
		ctx.scan("com.cisco.prj"); 
		ctx.refresh();
		
		OrderService service = ctx.getBean("orderService", OrderService.class);
	
		List<Product> products = service.getProducts();
		for(Product p : products) {
			System.out.println(p);
		}
		
		System.out.println("By ID");
		Product p = service.getProduct(2);
		System.out.println(p);
	}

}
