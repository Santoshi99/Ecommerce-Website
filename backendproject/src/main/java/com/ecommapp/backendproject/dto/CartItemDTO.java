package com.ecommapp.backendproject.dto;

import com.ecommapp.backendproject.model.Cart;
import com.ecommapp.backendproject.model.Product;

public class CartItemDTO {
	
	public CartItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItemDTO(int cartItemId, int quantity, double totalprice, Cart cart, Product product) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.cart = cart;
		this.product = product;
	}
	private int cartItemId;
	private int quantity;
	private double totalprice;
	private Cart cart;
	private Product product;
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
