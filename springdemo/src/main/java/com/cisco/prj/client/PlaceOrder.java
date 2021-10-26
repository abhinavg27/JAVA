package com.cisco.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.entity.Customer;
import com.cisco.prj.entity.Item;
import com.cisco.prj.entity.Order;
import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

public class PlaceOrder {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// scan for class with 6 sterotype annotations and create instances 
		ctx.scan("com.cisco.prj"); 
		ctx.refresh();
		
		OrderService service = ctx.getBean("orderService", OrderService.class);
	
		Customer c = new Customer();
		c.setEmail("gavin@cisco.com");
		
		Order o = new Order();
		o.setCustomer(c); // get from session; after login
		
		Product p1 = new Product();
		p1.setId(2); // Logitech Mouse
		
		
		Product p2 = new Product();
		p2.setId(1); // iPhone 13
	
		
		Item i1 = new Item();
		i1.setProduct(p1);
		i1.setQty(3);
		
		Item i2 = new Item();
		i2.setProduct(p2);
		i2.setQty(1);
		
		o.getItems().add(i1);
		o.getItems().add(i2);
		
		service.placeOrder(o);
	}

}
