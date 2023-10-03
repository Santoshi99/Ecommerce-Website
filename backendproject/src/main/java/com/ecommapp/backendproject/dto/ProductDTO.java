package com.ecommapp.backendproject.dto;

import com.ecommapp.backendproject.model.Category;

public class ProductDTO {
   

	private int productId;
	 private String productName;
	 private String productDesc;
	 private double productPrize;
	 private boolean stock=true;
	 private int productQuantity;
	 private boolean live;
	 private String imageName;
	 private CategoryDTO categorydto;
	 

		public ProductDTO(int productId, String productName, String productDesc, double productPrize, boolean stock,
				int productQuantity, boolean live, String imageName, CategoryDTO categorydto) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productDesc = productDesc;
			this.productPrize = productPrize;
			this.stock = stock;
			this.productQuantity = productQuantity;
			this.live = live;
			this.imageName = imageName;
			this.categorydto = categorydto;
		}
	 
	 public ProductDTO() {
		 super();
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


	public CategoryDTO getCategorydto() {
		return categorydto;
	}

	public void setCategorydto(CategoryDTO categorydto) {
		this.categorydto = categorydto;
	}
	
	 
}
