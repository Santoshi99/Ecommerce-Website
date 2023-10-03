package com.ecommapp.backendproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "product")
public class Product {


	 @Id
     @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="myseq")
	 //@SequenceGenerator(name="myseq",sequenceName="mysequence",allocationSize=10)
	 private int productId;
	 private String productName;
	 private String productDesc;
	 private double productPrize;
	 private boolean stock=true;
	 private int productQuantity;
	 private boolean live;
	 private String imageName;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
     private Category category;
	 
	 public Product(int productId, String productName, String productDesc, double productPrize, boolean stock,
			int productQuantity, boolean live, String imageName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrize = productPrize;
		this.stock = stock;
		this.productQuantity = productQuantity;
		this.live = live;
		this.imageName = imageName;
	}
	
	public Product() {
		
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductDesc() {
		return productDesc;
	}



	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}



	public double getProductPrize() {
		return productPrize;
	}



	public void setProductPrize(double productPrize) {
		this.productPrize = productPrize;
	}



	public boolean isStock() {
		return stock;
	}



	public void setStock(boolean stock) {
		this.stock = stock;
	}



	public int getProductQuantity() {
		return productQuantity;
	}



	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}



	public boolean isLive() {
		return live;
	}



	public void setLive(boolean live) {
		this.live = live;
	}



	public String getImageName() {
		return imageName;
	}



	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	 
}
