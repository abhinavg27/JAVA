package com.cisco.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cisco.prj.entity.Product;

public class ProductClient {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		products.add(new Product(224, "iPhone", 98000.00, "mobile"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		products.add(new Product(912, "One Plus", 32000.00, "mobile"));
		products.add(new Product(88, "HP Printer", 19000.00, "computer"));
		
		products.stream()
			.filter(p -> p.getCategory().equals("mobile"))
			.forEach(p -> System.out.println(p));
		
		System.out.println("**********");
		
		products.stream()
			.map(p -> p.getName())
			.forEach(System.out::println); // method reference
		
		System.out.println("*******");
		
		System.out.println("Names of Products which are of Computer category");
		products.stream()
			.filter(p -> p.getCategory().equals("computer"))
			.map(p -> p.getName())
			.forEach(System.out::println);
	
		
		List<String> names = products.stream()
				.filter(p -> p.getCategory().equals("computer"))
				.map(p -> p.getName())
				.collect(Collectors.toList());
		
		System.out.println(names);
		
		Map<String, List<Product>> categoryMap =  
				products.stream().collect(Collectors.groupingBy(p -> p.getCategory()));
		
		categoryMap.forEach((k,v) -> {
			System.out.println("Category : "  + k);
			v.forEach(System.out::println);
		});
		
		
		System.out.println("Reduce is to get aggregate [ sum() / avg() / count() / max()");
		
		
		 double sum = products.stream()
			.map(p -> p.getPrice())
			.reduce(0.0, (v1, v2) -> v1 + v2);
		 
		 System.out.println("Total : " + sum);
		 
		 double max =  products.stream()
					.map(p -> p.getPrice())
					.reduce(0.0, (v1, v2) -> v1 > v2 ? v1:v2);
		 System.out.println("Max:" + max);
		 
		 System.out.println("####################");
		 
		 List<Integer> ints = Arrays.asList(5,7,2,4,8,9,1,10);
		 
		 ints.stream().filter(elem -> elem % 2 == 0).forEach(System.out::println);
		 
	}

}
