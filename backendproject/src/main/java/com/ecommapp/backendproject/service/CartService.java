package com.ecommapp.backendproject.service;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.ecommapp.backendproject.Exception.ResourceNotFoundException;
import com.ecommapp.backendproject.Exception.UserNotFoundException;
import com.ecommapp.backendproject.dto.CartDTO;
import com.ecommapp.backendproject.dto.ItemRequest;
import com.ecommapp.backendproject.model.Product;
import com.ecommapp.backendproject.model.User;
import com.ecommapp.backendproject.model.CartItem;
import com.ecommapp.backendproject.model.Cart;
import com.ecommapp.backendproject.repository.CartRepository;
import com.ecommapp.backendproject.repository.ProductRepository;
import com.ecommapp.backendproject.repository.UserRepository;

@Service
public class CartService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ProductRepository prodRepo;
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private ModelMapper mapper;

	public CartDTO addItem(ItemRequest item, String Username) {
		
		int prodId = item.getProductId();
		int qnty = item.getQuantity();
		
		User user = this.userRepo.findByEmail(Username).orElseThrow(() -> new UserNotFoundException("User not found"));
		Product product = this.prodRepo.findById(prodId).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		
		//Stock check
		if(product.isStock()) {
			new ResourceNotFoundException("Product stock is not available");
		}
		
		//Create cartItem
		
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(qnty);
		double total = product.getProductPrize()*qnty;
		cartItem.setTotalprice(total);
		
	     Cart cart = user.getCart();
	     if(cart == null) {
	    	 cart = new Cart();
	     }
	     cartItem.setCart(cart);
	     Set<CartItem> items = cart.getCartItems();
	     
	     AtomicReference<Boolean> flag = new AtomicReference<>();
	    Set<CartItem> cartproducts =  items.stream().map((i) ->{ 
	    	if(i.getProduct().getProductId()==product.getProductId()) {
	    	     i.setQuantity(qnty);
	    		 i.setTotalprice(total);
	    		 flag.set(true);
	    	 
	          }return i;
	    }).collect(Collectors.toSet());
	     
	     if(flag.get()) {
	    	 items.clear();
	    	 items.addAll(cartproducts);
	     }
	     else {
	    	 items.add(cartItem);
	     }
	    	 Cart savedCart = this.cartRepo.save(cart);
	     
		return this.mapper.map(savedCart,CartDTO.class);
	}
	
	public CartDTO getcartAll(String email) {
		User user = this.userRepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("User not found"));
		Cart cart = this.cartRepo.findByUser(user).orElseThrow(()->new ResourceNotFoundException("Cart not found"));
		return this.mapper.map(cart, CartDTO.class);
	}
	
	public CartDTO getCartById(int cartId) {
		
		Cart cartbyId = this.cartRepo.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart Not found"));
		return this.mapper.map(cartbyId, CartDTO.class);
	}
	
	public CartDTO removeCartItemFromCart(String username, int productId) {
		
		User user = this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User not found"));
		Cart cart = user.getCart();
		Set<CartItem> items = cart.getCartItems();
		boolean remove = items.removeIf((i)-> i.getProduct().getProductId()==productId);
		Cart save = this.cartRepo.save(cart);
		return this.mapper.map(save, CartDTO.class);
		
		
	}
}
