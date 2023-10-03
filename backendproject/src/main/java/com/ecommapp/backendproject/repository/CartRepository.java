package com.ecommapp.backendproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommapp.backendproject.model.Cart;
import com.ecommapp.backendproject.model.User;

public interface CartRepository extends JpaRepository<Cart,Integer>{

	Optional<Cart> findByUser(User user);

}
