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

===============================

Lambda

(parameter) -> body

Many FunctionalInterfaces in Java 8, few are listed below:

1) Function [  R apply(T t); ]

Function<Integer, String> f = (x) -> "Hello " + x;

f.apply(5); returns "Hello 5"

2) BiFunction [  R apply(T t, U u); ]

3) Predicate [  boolean test(T t); ]

4) Consumer [   void accept(T t); ]

5) Runnable [ void run() ]

6) Comparator [ int compare (T o1, T o2)]

============================

OOP --> has methods which are tightly coupled to state of object

public class Account {
	private double balance; //state

	public void credit(double amt) {
		balance += amt;
	}

	public double getBalance() {
		return balance;
	}
}

Functional style of programming ==> functionalities which can be used on any object
Functional style uses high order function [ which accept or return a function]
* treat functions as first class members like objects / primitive

Commonly used HOF are:
1) filter [ returns a subset based on predicate function]
2) map [ transforms the data based on Function]
3) reduce [ aggregate function]
4) forEach [ consume every element and write to console / Network / database]
5) limit
6) skip
7) flatMap
...

https://rxmarbles.com/

Java 8 streams;

The above mentioned HOF work on stream; Stream is a channel along which data flows [ Collection / Network/ R2DBC / MongoDB]
 
 double sum = products.stream()
			.map(p -> p.getPrice())
			.reduce(0.0, (v1, v2) -> v1 + v2);

reduce(indentity, accumulator)
  T result = identity;
           for (T element : this stream)
               result = accumulator.apply(result, element)
           return result;

===================================

Spring Framework + JPA

SOLID Design Principle
S ==> Single Responsibility 
O ==> Open Close Principle [ Closed for chanage; open for extension]
L ==> Liskov Substition principle
I ==> Interface segregation
D ==> Dependency Injection


What is Spring Framework?
* provides Lightweight container which manages life-cycle of objects and depency injection in its core module.
* has many more module for EAI ==> Enterprise application integration [ database , NoSQL, Redis, JMS, EmailService, ..] ==> lots of templates are avaibles which make application development easy.

Guice (pronounced 'juice') is a lightweight dependency injection framework 

============================================

Spring framework uses XML or annotation as metadata for life-cycle of objects and depency injection

1) XML as metadata

interface EmployeeDao {
	void addEmployee(Employee e);
}

public class EmployeeDaoJdbcImpl implements EmployeeDao {
	void addEmployee(Employee e) {..}	
}

public class SampleService {
	EmployeeDao empDao;
	public SampleService(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	public void doAdd(Employee e) {
		empDao.addEmployee(e);
	}
}

beans.xml
<beans id="jdbc" class="pkg.EmployeeDaoJdbcImpl" />
<beans id="service" class="pkg.SampleService">
	<constuctor index="0" ref="jdbc" />
</beans>

====================



interface EmployeeDao {
	void addEmployee(Employee e);
}

public class EmployeeDaoJdbcImpl implements EmployeeDao {
	void addEmployee(Employee e) {..}	
}

public class EmployeeDaoMongoDbImpl implements EmployeeDao {
	void addEmployee(Employee e) {..}	
}

public class SampleService {
	EmployeeDao empDao;

	public void setDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}
	public void doAdd(Employee e) {
		empDao.addEmployee(e);
	}
}

beans.xml
<beans id="jdbc" class="pkg.EmployeeDaoJdbcImpl" />
<beans id="mongo" class="pkg.EmployeeDaoMongoDbImpl" />

<beans id="service" class="pkg.SampleService">
	<property name ="dao" ref="jdbc" />
</beans>

<property name ="dao" ref="jdbc" /> ==> setDao(jdbc);

===============================================================

Annotation as Metadata:
Spring creates instances of classes which has one of these annotations:
1) @Component
==> Untilty class / Helper
2) @Repository
==> DAO layer ==> interact with persistent Store
3) @Service
==> Service tier which is Transactional
4) @Controller
==> Traditional web application development
5) @RestController
==> RESTful Web Services
6) @Configuration
==> reading properties file and any custom configuration for applicaiton

Wiring is done using @Autowired annotation


interface EmployeeDao {
	void addEmployee(Employee e);
}

@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {
	void addEmployee(Employee e) {..}	
}

@Service
public class SampleService {
	@Autowired
	EmployeeDao empDao;
	 
	public void doAdd(Employee e) {
		empDao.addEmployee(e);
	}
}

==============



interface EmployeeDao {
	void addEmployee(Employee e);
}

@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {
	void addEmployee(Employee e) {..}	
}


@Repository
public class EmployeeDaoMongoImpl implements EmployeeDao {
	void addEmployee(Employee e) {..}	
}

@Service
public class SampleService {
	@Autowired
	EmployeeDao empDao;
	 
	public void doAdd(Employee e) {
		empDao.addEmployee(e);
	}
}

=========================================

Java Build Tool ==> Maven

ANT ==> build.xml [ target as clean, compile, package, jar files...]

Maven is a build tool ==> Main features manage dependencies; configure lifecycle management of applicaiton; uses pom.xml as configuration file; uses XML language

Gradle is a build tool similar to Maven uses "groovy" language

=============


ApplicationContext is an interface for Spring Container.

* ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

* new AnnotationConfigApplicationContext();


====
Problem: more than 1 bean of a giver interface to be wired
Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.cisco.prj.dao.EmployeeDao' available: expected single matching bean but found 2: employeeDaoFileImpl,employeeDaoJdbcImpl

Solutions:
1) Mark one of the bean as @Primary

@Primary
@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {


@Repository
public class EmployeeDaoFileImpl implements EmployeeDao {

2) use @Qualifier

@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {

@Repository
public class EmployeeDaoFileImpl implements EmployeeDao {


@Service
public class AppService {
	@Autowired
	@Qualifier("employeeDaoJdbcImpl")
	private EmployeeDao empDao;

3) using VM / Program arguments and @Profile

@Service
public class AppService {
	@Autowired
	private EmployeeDao empDao;


@Profile("dev")
@Repository
public class EmployeeDaoFileImpl implements EmployeeDao {

@Profile("prod")
@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {


Run As ==> Run Configurations
Arguments:
VM arguments

-Dspring.profiles.active=prod

=======================================================

* JDBC is an integration aPI to interact with Relational Database [ RDBMS ]

ORM framework
* Object Relational Mapping to simplify CRUD operations on top of JDBC

* Hibernate ==> JBoss ==> RedHat
* TopLink ==> Oracle
* KODO ==> BEA ==> Oracle
* JDO ==> Sun MS ==> Oracle
* OpenJPA ==> Apache
* EclipseLink ==> eclipse

JPA ==> Java Persistence API is a specification for ORM 

Building Blocks of ORM
1) DataSource
2) EntityManagerFactory
3) PersistenceContext
4) EntityManager



Within a persistence context, entities are managed within this environmet. 
The EntityManager controls their lifecycle, and they can access datastore resources.

* Primary KEY is AUTO INCREMENT; no need to pass it from application
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

===
* Primary key is assigned from Application
	@Id
	private int id;

