package com.cisco.prj;

import com.cisco.prj.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) throws Exception {
		Product p = new Product(454,"Name", 45345.22, 111);
		ObjectMapper mapper = new ObjectMapper();
		 mapper.writeValue(System.out, p) ;
	}

}
