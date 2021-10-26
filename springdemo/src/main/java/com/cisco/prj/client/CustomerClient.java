package com.cisco.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.entity.Customer;
import com.cisco.prj.service.OrderService;

public class CustomerClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// scan for class with 6 sterotype annotations and create instances 
		ctx.scan("com.cisco.prj"); 
		ctx.refresh();
		
		OrderService service = ctx.getBean("orderService", OrderService.class);
		
		Customer c1 = new Customer("harry@cisco.com", "Harry" , "Potter");
		Customer c2 = new Customer("gavin@cisco.com", "Gavin" , "King");
		
		service.addCustomer(c1);
		service.addCustomer(c2);
		
		List<Customer> customers = service.getCustomers();
		for(Customer c: customers) {
			System.out.println(c.getEmail() +", " + c.getFirstName());
		}
				

	}

}
