package com.ecommapp.backendproject.dto;

import java.util.List;



public class ProductResponse {

	public ProductResponse(List<ProductDTO> content, int pageNumber, int pageSize, int totalPages, int lastPage) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.lastPage = false;
	}
	
	public ProductResponse() {
		super();
	}
	private List<ProductDTO> content;
	private int pageNumber;
	private int pageSize;
	private int totalPages;
	private boolean lastPage;
	public List<ProductDTO> getContent() {
		return content;
	}
	public void setContent(List<ProductDTO> content) {
		this.content = content;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public boolean getLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	
}
