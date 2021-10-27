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

===================================


Recap:
1) Generic Collections using of <?> and <T>
	Generic class , Generic methods
2) Functional Style of Programming; @FunctionalInterface, HOF
3) java 8 streams [ map, filter, reduce, forEach, collect]
4) Spring Framework 5.2 version ==> Core Container provides DI and life cycle management
XML based metadata and annotaion based metadata;
@Component, @Repository, @Service, @Configuration, @Controller, @RestController
@Autowired ==> to wire dependencies
@Primary, @Qualifier, @Profile with VM arguments -Dspring.profiles.active=prod

5) ORM, EntityManagerFactory, PersistenceContext and EntityManager
6) @Entity, @Table, @Id, @Column



BiFunction<Integer,Integer,Integer> bifn = (x,y) -> x + y;


int x = bifn.apply(4,5); // 9


BiFunction<Integer,Double,String> bifn2 = (x, y) -> "Result " + (x +y);

String str - bifn2.apply(4, 1.2); // "Result 5.2"

==================================


Day 2

Spring creates instances of class using default constructor and it needs one of "6" annotations mentioned

case 1:

class without default constructor

public class EmailService {
	private String ip;
	private int port;

	public EmailService(String ip, int port) {
		...
	}

	public void sendEmail(String msg) {

	}
}

placing any of the "6" annotations on top of this class will lead to Spring initialization error


case 2:

class are provided by 3rd party libraries which doesn't have any of the above annotations; but we need objects
of those classes to be managed by Spring container

2.1) jackson library ObjectMapper
	java <--> json

		JAXB
		java <--> XML


Solution: use factory pattern

===

EmailService.java
MyConfig.java
AppService.java


=======================

Once MySQL container on docker is up and running

access MySQL terminal

$ docker exec -it local-mysql bash

# mysql -u root -p
Enter Password: Welcome123


mysql> create database CISCO_SPRING;
mysql> use CISCO_SPRING;

==============


ddl-auto

Hibernate property values are: create, update, create-drop, validate and none:
props.setProperty("hibernate.ddl-auto", "create");
create – Hibernate first drops existing tables, then creates new tables

props.setProperty("hibernate.ddl-auto", "update");
update – uses existing table or creates a new one if not available; alter table if required.

validate – Hibernate only validates whether the tables and columns exist, otherwise it throws an exception
none – this value effectively turns off the DDL generation



====

TransactionManager

1) Programatic Transaction using JDBC

public void transferFunds(Account fromAcc, Account toAcc, double amt) {
	Connection con = ...
	try {
		con.setAutoCommit(false); 
		PreparedStatement ps1 = "update fromAcc ...";
		PreparedStatement ps2= "update toAcc ...";
		ps1.executeUpdate();
		ps2.executeUpdate();
		con.commit();
	} catch(SQLException ex) {
		con.rollback();
	}
}


2) Programatic Transaction using Hibernate


public void transferFunds(Account fromAcc, Account toAcc, double amt) {
  Session ses = sessionFactory.getSession();
	try {
		Transaction tx = ses.beginTransaction();
	 	ses.update(fromAcc);
	 	ses.update(toAcc);
	 	ses.save(txinfo);
	 	send sms;
	 	send email
		tx.commit();
	} catch(SQLException ex) {
		tx.rollback();
	}
}


3) Declarative Tranasaction using PlatformTransactionManager

@Transactional
public void transferFunds(Account fromAcc, Account toAcc, double amt) {
	// jdbc or hiberante or jpa or jta
}

if exception is propagated out of the method "rollback" else "commit"

=======================================================

Service facade a layer on DAO operations; 
Normally combine many fine grained operations of DAO as one atomic unit of operation which is coarse grained.
Service code should be transactional instead of DAO code.

==========================================

https://github.com/spring-projects/spring-framework/blob/main/spring-jdbc/src/main/resources/org/springframework/jdbc/support/sql-error-codes.xml



Customer.java
CustomerDao.java
CustomerDaoJpaImpl.java
OrderService.java
CustomerClient.java


=========================================================

http://www.databaseanswers.org/data_models/index.htm

Mapping Associations 


Many-To-one JoinColumn will introduce FK in owning side

One-To-Many JoinColumn will introduce FK in child side

==========

Without Cascade:

@Entity
@Table(name="orders")
public class Order {
	@OneToMany
	@JoinColumn(name="order_fk")
	private List<Item> items = new ArrayList<>(); // order has many items

Assume Order has 4 items;

1) to save 
orderDao.save(order);
itemDao.save(i1);
itemDao.save(i2);
itemDao.save(i3);
itemDao.save(i4);

2) to delete
orderDao.delete(oid);
itemDao.delete(id1);
itemDao.delete(id2);
itemDao.delete(id3);
itemDao.delete(id4);


With Cascade:

@Entity
@Table(name="orders")
public class Order {
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order_fk")
	private List<Item> items = new ArrayList<>(); // order has many items


Assume Order has 4 items;

1) to save 
orderDao.save(order); 

saving an order saves items also
 

2) to delete
orderDao.delete(oid);
delte order deletes items also

==> No need for ItemDao

============

Fetch Strategy

1) ManyToOne is EAGER fetching 
2) OneToMany is LAZY fetching

orderDao.getOrder(1);
this fetches order entry and customer also

override strategy using:
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="order_fk")
	private List<Item> items = new ArrayList<>(); // order has many items
	
===

Dirty checking is the capability of ORM ==> within a transactional code if object becomes dirty ==> update SQL is sent

----------------

Fetch EAGER:
    select
        order0_.oid as oid1_2_0_,
        order0_.customer_fk as customer4_2_0_,
        order0_.order_date as order_da2_2_0_,
        order0_.total as total3_2_0_,
        customer1_.email as email1_0_1_,
        customer1_.first_name as first_na2_0_1_,
        customer1_.last_name as last_nam3_0_1_,
        items2_.order_fk as order_fk5_1_2_,
        items2_.itemid as itemid1_1_2_,
        items2_.itemid as itemid1_1_3_,
        items2_.amount as amount2_1_3_,
        items2_.product_fk as product_4_1_3_,
        items2_.qty as qty3_1_3_,
        product3_.id as id1_3_4_,
        product3_.name as name2_3_4_,
        product3_.price as price3_3_4_,
        product3_.qty as qty4_3_4_ 
    from
        orders order0_ 
    left outer join
        customers customer1_ 
            on order0_.customer_fk=customer1_.email 
    left outer join
        items items2_ 
            on order0_.oid=items2_.order_fk 
    left outer join
        products product3_ 
            on items2_.product_fk=product3_.id 
    where
        order0_.oid=?

 ----------------------

 Fetch LAZY:

 select
        order0_.oid as oid1_2_0_,
        order0_.customer_fk as customer4_2_0_,
        order0_.order_date as order_da2_2_0_,
        order0_.total as total3_2_0_,
        customer1_.email as email1_0_1_,
        customer1_.first_name as first_na2_0_1_,
        customer1_.last_name as last_nam3_0_1_ 
    from
        orders order0_ 
    left outer join
        customers customer1_ 
            on order0_.customer_fk=customer1_.email 
    where
        order0_.oid=?

 -----------------------------


 Bi-Directional relationship:


@Entity
@Table(name="orders")
public class Order {

	@ManyToOne()
	@JoinColumn(name="customer_fk")
	private Customer customer; // order is by customer


----

@Entity
@Table(name="customers")
public class Customer {
		@OneToMany(mappedBy = "customer")
		private List<Order> orders = new ArrayList<>();

==================


Many-to-Many ==> OneToMany and ManyToOne with association table

1) Project and Employee looks like ManyToMany [ Project has many employees; Employee works in many Project]

======================

Mapping Inheritance:
1) Single Table 

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type")
public abstract class Product {
		@Id
		private int id;
		private String name;
		private double price;

}

@Entity
@DiscriminatorValue("tv")
public class Tv extends Product {
	@Column(name="screen_type")
	String screenType;
}


@Entity
@DiscriminatorValue("mobile")
public class Mobile extends Product {
	String connectivity;
}

--

2) Table per class


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {
		@Id
		private int id;
		private String name;
		private double price;

}

@Entity
public class Tv extends Product {
	@Column(name="screen_type")
	String screenType;
}


@Entity
public class Mobile extends Product {
	String connectivity;
}

========================================================

Task:

1) Start new Spring applicaton ==> pom.xml
2) create 2 entites "Employee" and "Ticket"

1) Use case 1:
Employee raises a ticket

2) Use case 2:
Employee resolves a ticket

refer: 2. task.svg


===============================

Day 2 Recap:

Mapping associations:
one-to-many 
many-to-one

@JoinColumn() ==> Foreign Key

OneToOne
ManyToMany

Inheritance:
single table with discriminator column [ type ==> tv, mobile , "microwave"]
JOINED 
Products table ==> common fields
tv table
mobile table

DataSource, EntityManager, PeristenceContext, EntityManagerFactory,

DirtyChecking



Day 3

-------
Default package is jar
mvn package

OR

Run As => Maven Build 
Goals:
package

----------
pom.xml
<packaging>war</packaging>

Maven => update project ==> Check force update

WAR ==> Web Archive ==> Web based applications are bundeled as "war" files and deployed on server

==

<packaging>pom</packaging>
Parent Maven Project

<packaging>ear</packaging> 
Enterprise applicaiton ==> Distributed computing , EJB

===================

Tomcat / Eclipse Jetty are Java Servlet container.


============

Resources running on Servlet Container / Servlet Engine / Web Container needs configuration

class LoginServlet extends HttpServlet {
	public doGet(HttpServletRequest req, HttpServletResponse res) {

	}
	public doPost(HttpServletRequest req, HttpServletResponse res) {

	}
}

class RegisterServlet extends HttpServlet {
	public doGet(HttpServletRequest req, HttpServletResponse res) {

	}
	public doPost(HttpServletRequest req, HttpServletResponse res) {

	}
}


http://localhost:8080/login
http://localhost:8080/register

Deployment Descriptor for servlet engine: ==> web.xml

<servlet>
	<servlet-name>A</servlet-name>
	<servlet-class>pkg.LoginServlet</servlet-class>
</servlet>

<servlet-mapping>
		<servlet-name>A</servlet-name>
		<url-pattern>/login</url-pattern>
</servlet-mapping>

<servlet>
	<servlet-name>B</servlet-name>
	<servlet-class>pkg.RegisterServlet</servlet-class>
</servlet>

<servlet-mapping>
		<servlet-name>B</servlet-name>
		<url-pattern>/register</url-pattern>
</servlet-mapping>


===

Deployment Descriptor  using Annoations:

@WebServlet("/login")
class LoginServlet extends HttpServlet {
	public doGet(HttpServletRequest req, HttpServletResponse res) {

	}
	public doPost(HttpServletRequest req, HttpServletResponse res) {

	}
}

@WebServlet("/register")
class RegisterServlet extends HttpServlet {
	public doGet(HttpServletRequest req, HttpServletResponse res) {

	}
	public doPost(HttpServletRequest req, HttpServletResponse res) {

	}
}


==========

Spring Web MVC Module

MVC ==> Model View Controller

View ==> Presentation [ HTML, JSP, Theymeleaf]
Model ==> Business data and business logic [ DAO , entity , service]
Controller ==> Servlet acts as controller [ application logic]


Run As ==> Maven Build ==> Goals 
jetty:run

===================
 
 JSTL (JSP Standard Tag Library)
The JSP Standard Tag Library (JSTL) represents a set of tags to simplify the JSP development.

Core Tags:
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

Adding Validation to Web Application

===========

i18N ==> Internationalization

messages.properties
name.required=Provide Name, can't be Blank
price.invalid=:-( Negative value is not valid for price 


messages_fr.properties
name.required= ..
price.invalid= ..

messages_hi.properties

name.required= ..
price.invalid= ..

messages_ar.properties

name.required= ..
price.invalid= ..


Browser ==> locale setting is "arabic" searches for "messages_ar.properties" if not present uses "messages.properties"

==============================


CustomerController ==> add and list customers

==========================



Help ==> Eclipse Market Place

search for STS "GO"

install Spring Tools 4 any latest avaiable

=================================================








