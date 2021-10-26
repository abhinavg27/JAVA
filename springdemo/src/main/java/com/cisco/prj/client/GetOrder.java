package com.cisco.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.entity.Item;
import com.cisco.prj.entity.Order;
import com.cisco.prj.service.OrderService;

public class GetOrder {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// scan for class with 6 sterotype annotations and create instances 
		ctx.scan("com.cisco.prj"); 
		ctx.refresh();
		
		OrderService service = ctx.getBean("orderService", OrderService.class);
		
		Order o = service.getOrder(1);
		
		System.out.println(o.getOid() + ", " + o.getOrderDate() + "," + o.getTotal());
		System.out.println("Customer : " + o.getCustomer().getFirstName() + " " + o.getCustomer().getLastName());
		
		List<Item> items = o.getItems();
		System.out.println("Items:");
		for(Item i : items) {
			System.out.println(i.getProduct().getName() + " ==> " + i.getQty()  + " ---> " + i.getAmount());
		}
	
		System.out.println("Total :" + o.getTotal());
	}

}
