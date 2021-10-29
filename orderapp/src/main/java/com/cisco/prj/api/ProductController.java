package com.cisco.prj.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.afford;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("api/products")
public class ProductController {
	@Autowired
	private OrderService service;
	// http://localhost:8080/api/products/hateoas/3
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Product>> findOne(@PathVariable("id") int id) {
		Product p = service.getById(id);
		EntityModel<Product> em = EntityModel.of(p,
				linkTo(methodOn(ProductController.class).findOne(id)).withSelfRel()
				.andAffordance(afford(methodOn(ProductController.class).updateProduct(p.getId(), null)))
//				.andAffordance(afford(methodOn(ProductController.class).deleteProduct(id)))
				,
				linkTo(methodOn(ProductController.class).getProducts(0, 0)).withRel("products")
				);
		
		return ResponseEntity.ok(em);
	}
	
	// http://localhost:8080/api/products?page=3&size=20
	// http://localhost:8080/api/products
	@GetMapping()
	public @ResponseBody List<Product> getProducts(@RequestParam(name = "page", defaultValue = "-1") int page,
				@RequestParam(name="size", defaultValue = "0") int size) {
		if(page == -1 || size == 0) {
			return service.getProducts();
		} else {
			return service.paginatedProducts(page, size).getContent();
		}
	}
	
	//http://localhost:8080/api/products/3
//	@Cacheable(value="productCache", key = "#id")
//	@GetMapping("/{id}")
//	public @ResponseBody Product getProduct(@PathVariable("id") int id) {
//		System.out.println("Cache Miss !!");
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			return service.getById(id);
//		} catch (Exception e) {
//			throw new IllegalArgumentException("Product with id : " + id + " doesn't exist");
//		}
//	}
	
	@Cacheable(value="productCache", key = "#p.id")
	@PostMapping()
	public ResponseEntity<Product> addProduct(@RequestBody @Valid Product p) {
		p = service.addProduct(p);
		return new ResponseEntity<Product>(p, HttpStatus.CREATED);
	}
	
	@CachePut(value="productCache", key ="#id")
	@PutMapping("/{id}")
	public @ResponseBody Product updateProduct(@PathVariable("id") int id, @RequestBody Product p) {
		return service.modifyProduct(p.getPrice(), id);
	}
	
	@CacheEvict(value="productCache", key ="#id")
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		return "deleted!!!";
	}
}
