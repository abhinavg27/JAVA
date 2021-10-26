package com.cisco.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void placeOrder(Order o) {
		List<Item> items = o.getItems();
		double total = 0.0;
		for(Item item : items) {
			Product p = productDao.getProduct(item.getProduct().getId()); // client sends only product id
			item.setAmount(p.getPrice() * item.getQty()); // add discount , tax
			total += item.getAmount();
			p.setQuantity(p.getQuantity() - item.getQty()); // Dirty checking ==> update SQL
		}
		o.setTotal(total);
		orderDao.addOrder(o); // cascade saves items also
	}
	
	public Order getOrder(int id) {
		return orderDao.getOrder(id);
	}
	
	@Transactional
	public void addCustomer(Customer c) {
		customerDao.addCustomer(c);
	}
	
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}
	
	@Transactional
	public void addProduct(Product p) {
		productDao.addProduct(p);
	}

	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	public Product getProduct(int id) {
		return productDao.getProduct(id);
	}

	@Transactional
	public void updateProduct(Product p) {
		productDao.updateProduct(p);
	}

	@Transactional
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}
}
