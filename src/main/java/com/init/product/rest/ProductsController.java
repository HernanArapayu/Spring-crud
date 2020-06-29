package com.init.product.rest;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.product.Entitys.Product;
import com.init.product.dao.Iproduct;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	
	@Autowired
	private Iproduct repo;
	
	
	//@GetMapping
	public ResponseEntity<Product> getProduct(){
		Product product= new Product();
		product.setId(1L);
		product.setName("Manzana");
		
		return ResponseEntity.ok(product);
	}
	
	
	@RequestMapping(value="lista")
	public ResponseEntity<List<Product>> getProductList(){
		
		List<Product> productos = repo.findAll();
		
		return ResponseEntity.ok(productos);
		
	}
	
	
	
	
	
	@RequestMapping(value="lista/{id}")
	public ResponseEntity<Product> getProductbyId(@PathVariable("id") Long id){
		
		
		
		Optional<Product> productoptional = repo.findById(id);
		
		
		if(productoptional.isPresent()) {
			
			
			return ResponseEntity.ok(productoptional.get());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	@DeleteMapping(value="lista/{id}")
	public ResponseEntity<Product> deleteProductbyId(@PathVariable("id") Long id){
		
		
		
		repo.deleteById(id);
			return ResponseEntity.ok(null);
		
		
		
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product product2 = repo.save(product);
		
		return ResponseEntity.ok(product2);
		
		
	}
	
	
	

}
