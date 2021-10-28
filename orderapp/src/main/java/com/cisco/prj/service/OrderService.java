package com.cisco.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.CustomerDao;
import com.cisco.prj.dao.OrderDao;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.entity.Customer;
import com.cisco.prj.entity.Item;
import com.cisco.prj.entity.Order;
import com.cisco.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Transactional
	public Order placeOrder(Order o) {
		List<Item> items = o.getItems();
		double total = 0.0;
		for(Item item : items) {
			Product p = productDao.findById(item.getProduct().getId()).orElseThrow(); // client sends only product id
			item.setAmount(p.getPrice() * item.getQty()); // add discount , tax
			total += item.getAmount();
			p.setQuantity(p.getQuantity() - item.getQty()); // Dirty checking ==> update SQL
		}
		o.setTotal(total);
		return orderDao.save(o); // cascade saves items also
	}
	
	public List<Order> getOrders() {
		return orderDao.findAll();
	}
	
	public Product addProduct(Product p) {
		return productDao.save(p);
	}
	
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	
	public Product getById(int id) {
		return productDao.findById(id).orElseThrow();
	}
	
	public List<Product> getByRange(double lower, double higher) {
		return productDao.getByRange(lower, higher);
	}
	
	public Page<Product> paginatedProducts(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return productDao.findAll(pageable);
	}
	
	@Transactional
	public Product modifyProduct(double price, int id) {
		productDao.updateProduct(price, id);
		return getById(id);
	}
	
	public Customer addCustomer(Customer c) {
		return customerDao.save(c);
	}
	
	public List<Customer> getCustomers() {
		return customerDao.findAll();
	}
}
