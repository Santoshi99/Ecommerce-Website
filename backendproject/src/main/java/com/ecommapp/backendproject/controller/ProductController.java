package com.ecommapp.backendproject.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommapp.backendproject.dto.AppConstants;
import com.ecommapp.backendproject.dto.ProductDTO;
import com.ecommapp.backendproject.dto.ProductResponse;
import com.ecommapp.backendproject.model.Product;
import com.ecommapp.backendproject.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	
	@PostMapping("/create/{catId}")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product, @PathVariable int catId) {
		
		System.out.println(product);
		ProductDTO create_product = productService.createProduct(product,catId);
		return new ResponseEntity<ProductDTO>(create_product,HttpStatus.CREATED);
	}
	
	@GetMapping("/view")
	public ProductResponse viewAllProduct(@RequestParam(value="pageNumber",defaultValue=AppConstants.PAGE_NUMBER_STRING,required=false) int pageNumber,
			@RequestParam(value="pageSize",defaultValue=AppConstants.PAGE_SIZE_STRING,required=false) int pageSize,
		@RequestParam(value="sortBy",defaultValue=AppConstants.SORT_BY_STRING,required=false) String sortBy,
		@RequestParam(value="sortDir",defaultValue=AppConstants.SORT_DIR_STRING,required=false) String sortDir
	){
		ProductResponse viewpage  = productService.viewAll(pageNumber,pageSize,sortBy,sortDir);
		return viewpage;
	}
	
	@GetMapping("/view/{productId}")
	public ResponseEntity<Optional<ProductDTO>> viewProductbyId(@PathVariable int productId) {
		
		Optional<ProductDTO> view_product = productService.viewProductById(productId);
		return new ResponseEntity<Optional<ProductDTO>>(view_product,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
	}
	
	@PutMapping("/update/{productId}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable int productId, @RequestBody Product newproduct) {
		
		ProductDTO updated = productService.updateProduct(productId,newproduct);
		return new ResponseEntity<ProductDTO>(updated,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/category/{catId}")
	public ResponseEntity<List<ProductDTO>> getProductbyCategory(@PathVariable int catId){
		
		List<ProductDTO> productbyCat = productService.findProductByCategory(catId);
		
		return new ResponseEntity<List<ProductDTO>>(productbyCat,HttpStatus.OK);
	}
}
