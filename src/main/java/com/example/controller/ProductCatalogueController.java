package com.example.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.Product;
import com.example.mapper.ProductType;
import com.example.repository.ProductCatalogRepository;
import com.example.repository.ProductRepository;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This class is responsible for product catalog operation like product information add,fetch and delete
 * @author Sumit
 *
 */
@RestController
@RequestMapping("/productCatalog")
@Api(value="Product Catalog Information")
public class ProductCatalogueController {
	
	
	Gson gson= new Gson();
	
	@Autowired
	private ProductCatalogRepository productCatalogRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * This method is used to add the product type
	 * @param productType
	 * @return object of ResponseEntity<String>
	 */
	@ApiOperation(value="Add product type  infromation" , response=ResponseEntity.class)
	@RequestMapping(value = "/addProductType", method = RequestMethod.POST)
    public ResponseEntity < String > addProductType(@RequestBody ProductType productType){
		productCatalogRepository.save(productType);
        return new ResponseEntity<String>("Product added successfully",HttpStatus.OK);
    }
	
	/**
	 * This method is used to add the product information
	 * @param product
	 * @return  object of ResponseEntity<String>
	 */
	@ApiOperation(value="Add product information" , response=ResponseEntity.class)
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ResponseEntity < String > addProduct(@RequestBody Product product){
		ProductType productType =productCatalogRepository.findByProductTypeName(product.getProductType().getProductTypeName());
		if(productType!=null){
			product.setProductType(productType);
		}
		productRepository.save(product);
        return new ResponseEntity<String>("Product added successfully",HttpStatus.OK);
    }
	
	/**
	 * This method is used to fetch the product information
	 * @param productTypeName
	 * @return  object of ResponseEntity<String>
	 */
	@ApiOperation(value="Fetch the product based on product type" , response=ResponseEntity.class)
	@RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    public Set<Product> getProduct(@RequestParam("productTypeName") String productTypeName) {
		ProductType productType = productCatalogRepository.findByProductTypeName(productTypeName);
		Set<Product> productList = new HashSet<Product>();
		if(productType!= null){
			productList = productType.getProductList();
		}
		return productList;
    }
	
	/**
	 * This method is used to delete the product
	 * @param productName
	 * @return  object of ResponseEntity<String>
	 */
	@ApiOperation(value="Delete product based on product name" , response=ResponseEntity.class)
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE)
	public ResponseEntity <String>  deleteProduct(@RequestParam("productName") String productName){
		Product product=productRepository.findByProductName(productName);
		String msg = "";
		if(product!=null){
			product.setProductType(null);
			productRepository.delete(product);
			msg="Product deleted successfully";
		}
		else{
			msg="No Product Present in the product catalog with name "+productName;
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
}
