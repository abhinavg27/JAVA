package com.cisco.prj.dao;

import java.util.List;

import com.cisco.prj.entity.Product;

public interface ProductDao {
	public void addProduct(Product p);
	List<Product> getProducts();
	Product getProduct(int id);
	void updateProduct(Product p);
	void deleteProduct(int id);
}
