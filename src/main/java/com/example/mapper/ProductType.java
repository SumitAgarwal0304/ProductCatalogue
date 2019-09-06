package com.example.mapper;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="product_type")

public class ProductType{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	
	@Column(name="product_type_name",unique=true)
	private String productTypeName;
	
	@Column(name="product_type_desc")
	private String productTypeDesc;
	
	
	@OneToMany(mappedBy="productType",cascade=CascadeType.ALL, 
	        orphanRemoval = true,fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Product> productList;

	

public void addProduct(Product product) {
	productList.add(product);
	product.setProductType(this);
}

public void removeProduct(Product product) {
	productList.remove(product);
	product.setProductType(null);
}

	/**
	 * @return the productTypeName
	 */
	public String getProductTypeName() {
		return productTypeName;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param productTypeName the productTypeName to set
	 */
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	/**
	 * @return the productTypeDesc
	 */
	public String getProductTypeDesc() {
		return productTypeDesc;
	}

	/**
	 * @param productTypeDesc the productTypeDesc to set
	 */
	public void setProductTypeDesc(String productTypeDesc) {
		this.productTypeDesc = productTypeDesc;
	}

	/**
	 * @return the productList
	 */
	public Set<Product> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(Set<Product> productList) {
		productList = productList;
	}

	

	
}
