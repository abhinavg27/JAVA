package com.cisco.prj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

@Configuration
public class AppRunner implements CommandLineRunner {
	@Autowired
	private OrderService service;
	
	@Override
	public void run(String... args) throws Exception {
//		addProduct();
//		displayProductId();
//		displayPageWise();
		
		testUpdate();
	}

	private void testUpdate() {
		Product p = service.modifyProduct(825.99, 2);
		System.out.println(p.getPrice());
	}

	private void addProduct() {
		Product p = new Product(0, "LG AC", 51000.00, 100);
		p = service.addProduct(p);
		System.out.println("Added : " + p.getId());
	}

	private void displayPageWise() {
		Page<Product> productPage = service.paginatedProducts(1, 2); // page starts from 0
		System.out.println("Pages :" + productPage.getTotalPages());
		System.out.println("Page #" + productPage.getNumber());
		
		List<Product> products = productPage.getContent();
		for(Product p: products) {
			System.out.println(p.getId() + "," + p.getName()  + "," + p.getPrice());
		}
		
	}

	private void displayProductId() {
		Product p = service.getById(1);
		System.out.println(p.getName());
	}
	
	 
}
