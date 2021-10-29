package com.cisco.prj.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.entity.Product;

@BasePathAwareController
public class ProductController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(path="products", method = RequestMethod.GET)
	public @ResponseBody List<Product> get() {
		return Arrays.asList(new Product(55,"A", 22, 221), new Product(72,"B",256,111));
	}
}
