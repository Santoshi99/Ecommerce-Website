package com.ecommapp.backendproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommapp.backendproject.model.Category;
import com.ecommapp.backendproject.dto.CategoryDTO;
import com.ecommapp.backendproject.repository.CategoryRepository;
import com.ecommapp.backendproject.Exception.ResourceNotFoundException;
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper mapper;
	
	public CategoryDTO create(CategoryDTO dto) {
		Category cat = this.mapper.map(dto, Category.class);
		Category save = this.categoryRepository.save(cat);
		return this.mapper.map(save, CategoryDTO.class);
	}
	
	public CategoryDTO update(int categoryId, CategoryDTO newdto) {
		
		Category oldcat  = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("This category Id not found"));
		
		oldcat.setTitle(newdto.getTitle());
		Category save = this.categoryRepository.save(oldcat);
		return this.mapper.map(save, CategoryDTO.class);
	}
	
	public void delete(int categoryId) {
		
		Category cat = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("This category Id not found"));
				categoryRepository.delete(cat);
		
	}
	
	public CategoryDTO getbyId(int categoryId) {
		Category oldcat = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("This category Id not found"));
		return this.mapper.map(oldcat, CategoryDTO.class);
	}
	
	public List<CategoryDTO> getAll() {
		List<Category> listofcategories = this.categoryRepository.findAll();
		List<CategoryDTO> listofdtocat = listofcategories.stream().map(cat -> this.mapper.map(cat,CategoryDTO.class)).collect(Collectors.toList());
		return listofdtocat;
	}
}
