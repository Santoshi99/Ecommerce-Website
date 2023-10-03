package com.ecommapp.backendproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommapp.backendproject.dto.CategoryDTO;
import com.ecommapp.backendproject.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
	public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO catdto) {
		CategoryDTO create = categoryService.create(catdto);
		return new ResponseEntity<CategoryDTO>(create,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{catId}")
	public ResponseEntity<CategoryDTO> update(@PathVariable int catId, @RequestBody CategoryDTO catdto) {
		CategoryDTO update_cat = categoryService.update(catId, catdto);
		return new ResponseEntity<CategoryDTO>(update_cat,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<String> delete(@PathVariable int categoryId) {
		 categoryService.delete(categoryId);
		 return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	
	@GetMapping("/get/{categoryId}")
	public ResponseEntity<CategoryDTO> getbyId(@PathVariable int categoryId) {
		CategoryDTO getId = categoryService.getbyId(categoryId);
		return new ResponseEntity<CategoryDTO>(getId,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<CategoryDTO>> getAll() {
		List<CategoryDTO> getAll = categoryService.getAll();
		return new ResponseEntity<List<CategoryDTO>>(getAll,HttpStatus.ACCEPTED);
	}
	
}
