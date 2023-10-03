package com.ecommapp.backendproject.dto;

import java.util.HashSet;
import java.util.Set;

import com.ecommapp.backendproject.model.CartItem;
import com.ecommapp.backendproject.model.User;

public class CartDTO {

	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDTO(int cartId, Set<CartItemDTO> cartItems, User user) {
		super();
		this.cartId = cartId;
		this.cartItems = cartItems;
		this.user = user;
	}
	private int cartId;
	private Set<CartItemDTO> cartItems = new HashSet<>();
	private User user;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Set<CartItemDTO> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Set<CartItemDTO> cartItems) {
		this.cartItems = cartItems;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
