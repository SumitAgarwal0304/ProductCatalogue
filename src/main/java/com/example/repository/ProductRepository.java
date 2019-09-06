package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mapper.Product;
import com.example.mapper.ProductType;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
		
	public Product findByProductName(String productName);
	
	public ProductType findById(long id);
}
