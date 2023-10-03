package com.ecommapp.backendproject.dto;

import java.util.Set;

import com.ecommapp.backendproject.dto.ProductDTO;

public class CategoryDTO {

	
	
	private int categoryId;
	private String title;
	private Set<ProductDTO> product;
	
	public CategoryDTO(int categoryId, String title, Set<ProductDTO> product) {
		super();
		this.categoryId = categoryId;
		this.title = title;
		this.product = product;
	}
	
	public CategoryDTO() {
		super();
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<ProductDTO> getProduct(Set<ProductDTO> product){
		return product;
	}
	public void setProduct(Set<ProductDTO> product) {
		this.product=product;
	}
	
}
