package com.ecommapp.backendproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommapp.backendproject.model.Category;
import com.ecommapp.backendproject.model.Product;


public interface ProductRepository extends JpaRepository<Product,Integer>{

	List<Product> findByCategory(Category category); 
}
