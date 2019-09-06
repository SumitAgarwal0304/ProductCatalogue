package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mapper.Product;
import com.example.repository.ProductCatalogRepository;




@Component
public class ProductCatalogService {
	
	/*@Autowired
	private ProductCatalogRepository productCatalogRepository;
	
	public void addProduct(Product product){
		System.out.println("Service:"+product.getProductName());
		System.out.println("Repo"+ this.productCatalogRepository);
		this.productCatalogRepository.save(product);
	}*/
}
