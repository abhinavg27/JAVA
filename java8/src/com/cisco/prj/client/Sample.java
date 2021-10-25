package com.cisco.prj.client;

@FunctionalInterface
interface Computation {
	int compute(int x, int y);
}

public class Sample {

	public static void main(String[] args) {
		// Anonymous class
		Computation add = new Computation() {
			@Override
			public int compute(int x, int y) {
				return x + y;
			}
		};
		
		System.out.println(add.compute(5, 4));
		
		// Lambda expression
		Computation sub =  (int x, int y) -> {
				return x - y;
		};
		
		System.out.println(sub.compute(5, 4));
		
		// Lambda expression with type inference
		Computation multiply = (x,y) -> x * y;
		System.out.println(multiply.compute(5, 4));
		
	}

}
