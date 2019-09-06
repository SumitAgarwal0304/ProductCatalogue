package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.mapper.Product;
import com.example.mapper.ProductType;
import com.example.repository.ProductCatalogRepository;

@SpringBootApplication
@ComponentScan(basePackages="com.example.*")
@EnableJpaRepositories("com.example.repository")
@EntityScan(basePackages = "com.example.*")
public class ProductCatalogueServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueServiceApplication.class, args);
	}
	
	@Autowired
	private ProductCatalogRepository productCatalogRepository;

	@Override
	public void run(String... arg0) throws Exception {
		/*
		ProductType productType = new ProductType("Beverages", "Beer");
		
		Product product1 = new Product("Beer", 100.0);
		Product product2 = new Product("Wisky", 150.0);
		productType.getProductList().add(product1);
		productType.getProductList().add(product2);
		productCatalogRepository.save(productType);*/
		
	}
}
