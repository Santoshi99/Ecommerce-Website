package com.ecommapp.backendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommapp.backendproject.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
}
