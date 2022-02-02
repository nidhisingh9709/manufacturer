package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ProductService;
import com.example.demo.entity.Product;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	public Iterable<Product> getDetails() {
		return productService.getProductDetail();
	}

	@GetMapping("/{productId}/product")

	public Optional<Product> getProductDetails(@PathVariable("productId") Integer productId) {

		return productService.getProductDetails(productId);
	}

	// create new contact
	@PostMapping("/addproduct")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createProduct(@RequestBody @Valid Product product) {
		productService.saveProduct(product);
	}

	// Delete Records
	@DeleteMapping("/{productId}/deleteproduct")
	public void deleteProduct(@PathVariable("productId") Integer productId) {
		// TODO Auto-generated method stub
		productService.deleteProduct(productId);
	}

	// update
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);

	}
}
