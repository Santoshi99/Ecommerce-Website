package com.ecommapp.backendproject.dto;

public class ItemRequest {
	public ItemRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemRequest(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	private int productId;
	private int quantity;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
