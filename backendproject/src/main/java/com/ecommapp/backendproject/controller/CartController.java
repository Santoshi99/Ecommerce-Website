package com.ecommapp.backendproject.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommapp.backendproject.dto.CartDTO;
import com.ecommapp.backendproject.dto.ItemRequest;
import com.ecommapp.backendproject.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/")
	public ResponseEntity<CartDTO> addToCart(@RequestBody ItemRequest item, Principal principal){
		
		CartDTO addItem = this.cartService.addItem(item, principal.getName());
		return new ResponseEntity<CartDTO>(addItem,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<CartDTO> getAllCart(Principal principal){
		
		CartDTO allcart = this.cartService.getcartAll(principal.getName());
		return new ResponseEntity<CartDTO>(allcart,HttpStatus.OK);
	}
	
	@GetMapping("/{cartId}")
	public ResponseEntity<CartDTO> getCartById(@PathVariable int cartId){
		
		CartDTO cartById = this.cartService.getCartById(cartId);
		return new ResponseEntity<CartDTO>(cartById,HttpStatus.OK);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<CartDTO> deleteCartItemFromCart(@PathVariable int productId, Principal p){
		CartDTO remove = this.cartService.removeCartItemFromCart(p.getName(), productId);
		return new ResponseEntity<CartDTO>(remove,HttpStatus.OK);
		
	}
}
