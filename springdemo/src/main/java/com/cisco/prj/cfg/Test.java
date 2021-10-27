package com.cisco.prj.cfg;

import java.lang.reflect.Method;

import com.cisco.prj.entity.Product;

public class Test {

	public static void main(String[] args) throws Exception {
		Product p = new Product(10,"A",444,222);
		Method[] methods = p.getClass().getDeclaredMethods();
		for(Method m : methods) {
			if(m.getName().startsWith("get")) {
				System.out.println(m.invoke(p));
			}
		}
	}

}
