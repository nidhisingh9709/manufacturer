package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Component;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired 
	ProductRepository productRepository;

	public Iterable<Product> getProductDetail() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Optional<Product> getProductDetails(Integer productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}

	@Transactional
	public void saveProduct(@Valid Product product) {
		// TODO Auto-generated method stub
		
		productRepository.save(product);
		
	}
    @Transactional
	public void deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
	}
    @Transactional
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}
}
