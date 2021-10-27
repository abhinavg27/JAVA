package com.cisco.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

@Controller
public class ProductController {
	@Autowired
	private OrderService service;
	
	@RequestMapping("getProducts.do")
	public ModelAndView getProducts() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("products", service.getProducts()); // model data
		mav.setViewName("print.jsp");
		return mav;
	}
	
	@RequestMapping("productForm.do")
	public ModelAndView getProductForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", new Product()); // model data
		mav.setViewName("productInput.jsp");
		return mav;
	}
	
	@RequestMapping("addProduct.do")
	public ModelAndView addProduct(@ModelAttribute("product") Product p) {
		ModelAndView mav = new ModelAndView();
		service.addProduct(p);
		mav.addObject("msg", "Product added!!!");
		mav.setViewName("index.jsp");
		return mav;
	}
}
