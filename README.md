# Advance JAVA

Banuprakash C

Full Stack Architect,

Co-founder Lucida Technologies Pvt Ltd.,

Corporate Trainer,

Email: banuprakashc@yahoo.co.in

https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/JAVA


Softwares Required:
1) Java 11
	https://jdk.java.net/java-se-ri/11

2) Eclipse IDE for Enterprise Java Developers: 
	https://www.eclipse.org/downloads/packages/release/2020-03/m1/eclipse-ide-enterprise-java-developers

3) MySQL  [ Prefer on Docker]

Install Docker Desktop

Docker steps:

a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -it local-mysql /bin/bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit

==========

Java 8 features
* Generic collection
* Lambda expression
* Java 8 stream

Spring Framework
Java Persistence API
Buidling Traditional Web application

Spring Boot 
Building Secure RESTful Web services

--------------------------------------



Collection API ==> Data Containers provided by Java ==> Java Collection Framework

Generics:

class Rectangle <T> { ==> class Rectangle {
	T width;					Object width;
	T breadth;					Object breadth;


}							}


Rectangle<Integer> r1 = new Rectangle<>(4, 5); T is treated as Integer


Integer is a type wrapper class for "int" primitive type

int x = 10;

Integer iX = x; // autoboxing

int y = iX; // unboxing


Rectangle<Double> r2 = new Rectangle<>(4.2, 1.5); T is treated as Double

Rectangle<String> r3 = new Rectangle<>("A", "B");

Rectangle<String> r3 = new Rectangle<String>("A", "B");




class Rectangle <T extends Number> { 		==> class Rectangle {
	T width;										Number width;
	T breadth;										Number breadth;


}									}


Rectangle<String> r3 = new Rectangle<String>("A", "B");// error

===============================


Object[] elems = new String[3]; // valid

List<Object> list = new ArrayList<String>(); // error


class Product {

}

class Tv extends Product {

}

Object o = new Product();
Object o = new Tv();
Product p = new Tv();

List<?> is refered as unkonow type; can access any type of collection; mutation is not allowed

If T is Tv

List<? super T> dest

dest can be Tv, Product or Object

If <T> is Product

List<? extends T> meaining it can be Product or Tv


====================

	private static <T> void copy(List<T> dest, List<T> src) {
		for(T obj : src) {
			dest.add(obj);
		}
	}

	// PECS ==> Producer extends Consumer Super

	private static <T> void copy(List<? super T> dest, List<? extends T> src) {
		for(T obj : src) {
			dest.add(obj);
		}
	}

=====================


Functional Interface and Lambda expression

Anonymous class

interface Flyable {
	void fly();
}

Flyable f = new Flyable(); // error

"f" is an object of anonymous class
Flyable f = new Flyable() {
	public void fly() {
		...
	}
};

class Bird implements Flyable {
	// state
	// behaviour
	public void fly() {
		...
	}
	
}

Flyable f = new Bird();


Dummy1.java
Dummy2.java

Metaspace

===

Test.java

public class Test {
  public static void main(String[] args) {
     // r is an object of anonymous class
     Runnable r = new Runnable() {
        public void run() {
	
        }
    };
  }
}

javap -p Test.class
Compiled from "Test.java"
public class Test {
  public Test();
  public static void main(java.lang.String[]);
}


javap -p Test$1.class
Compiled from "Test.java"
class Test$1 implements java.lang.Runnable {
  Test$1();
  public void run();
}

==========================


FunctionalInterface is an interface where only one method of it has to be defined.


public class Test {
  public static void main(String[] args) {
     // r is an object of anonymous class
     Runnable r = () -> {    };
  }
}

javap -p Test.class
Compiled from "Test.java"
public class Test {
  public Test();
  public static void main(java.lang.String[]);
  private static void lambda$main$0();
}

=================

