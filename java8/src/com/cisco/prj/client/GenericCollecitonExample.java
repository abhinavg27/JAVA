package com.cisco.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericCollecitonExample {

	public static void main(String[] args) {
		List<String> sList = Arrays.asList("Hello", "World", "Welcome", "to", "Cisco");
		List<Integer> iList = Arrays.asList(4,22,1,72);
		print(sList);
		print(iList);
		
		List<String> copyStr = new ArrayList<>();
		List<Integer> copyInteger = new ArrayList<>();
		copy(copyStr, sList);
		copy(copyInteger, iList);
		
		System.out.println(copyStr);
		System.out.println(copyInteger);
	}

	private static <T> void copy(List<? super T> dest, List<? extends T> src) {
		for(T obj : src) {
			dest.add(obj);
		}
	}

	private static void print(List<?> sList) {
		for(Object o : sList) {
			System.out.println(o);
		}
	}

}
