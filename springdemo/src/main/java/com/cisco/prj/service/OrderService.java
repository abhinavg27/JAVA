package com.cisco.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;

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
