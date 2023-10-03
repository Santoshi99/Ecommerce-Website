package com.ecommapp.backendproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecommapp.backendproject.Exception.ResourceNotFoundException;
import com.ecommapp.backendproject.dto.ProductDTO;
import com.ecommapp.backendproject.dto.ProductResponse;
import com.ecommapp.backendproject.dto.CategoryDTO;
import com.ecommapp.backendproject.model.Category;
import com.ecommapp.backendproject.model.Product;
import com.ecommapp.backendproject.repository.CategoryRepository;
import com.ecommapp.backendproject.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	private ProductDTO newprod;
	@Autowired
	private CategoryRepository categoryRepo;
	
	public ProductDTO createProduct(ProductDTO product, int catId) {
		
		Category cat = this.categoryRepo.findById(catId).orElseThrow(()-> new ResourceNotFoundException("This catgoeryId is not present"));
		
		Product entity = toEntity(product);
		entity.setCategory(cat); 
		Product saved_product = productRepository.save(entity);
		ProductDTO dto = toDto(saved_product);
		return dto;
	}
	
	public ProductResponse viewAll(int pageNumber, int pageSize, String sortBy, String sortDir){
		Sort sort = null;
		if(sortDir.trim().toLowerCase().equals("asc")) {
			sort = Sort.by(sortBy).ascending();
		}else {
			Sort.by(sortBy).descending();
		}
			
		Pageable pageable = PageRequest.of(pageNumber,  pageSize, sort);
		
		Page<Product> page = this.productRepository.findAll(pageable);
		List<Product> pageProduct = page.getContent();
		List<Product> product = pageProduct.stream().filter(p->p.getCategory()!=null).collect(Collectors.toList());
		
		List<ProductDTO> productdto = product.stream().map(p->this.toDto(p)).collect(Collectors.toList());
		
		ProductResponse response = new ProductResponse();
		response.setContent(productdto);
		response.setLastPage(page.isLast());
		response.setPageNumber(page.getNumber());
		response.setPageSize(page.getSize());
		response.setTotalPages(page.getTotalPages());
		//List<ProductDTO> viewProduct = productRepository.findAll().stream().map(product -> this.toDto(product)).collect(Collectors.toList());
		
		return response;
		
	}
	
	public Optional<ProductDTO> viewProductById(int productId) {
		
		Optional<Product> view_prod = Optional.ofNullable(productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException(+productId+"from this productId product not found")));
		
		 view_prod.ifPresent(prod -> {newprod= this.toDto(prod);});
		return Optional.ofNullable(newprod);
		
	}

	public void deleteProduct(int productId) {
		Optional<Product> prod = Optional.ofNullable(productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException(+productId+"from this productId product not found")));
		
		prod.ifPresent((product)->productRepository.delete(product));
	}
	
	public ProductDTO updateProduct(int productId, Product newproduct) {
		Optional<Product> findproduct = Optional.ofNullable(productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException(+productId+"from this productId product not found")));
		findproduct.ifPresent((oldprod) -> {oldprod.setImageName(newproduct.getProductName());
			                              oldprod.setLive(newproduct.isLive());
			                              oldprod.setProductDesc(newproduct.getProductDesc());
			                              oldprod.setProductName(newproduct.getProductName());
			                              oldprod.setProductPrize(newproduct.getProductPrize());
			                              oldprod.setProductQuantity(newproduct.getProductQuantity());
			                              oldprod.setStock(newproduct.isStock());
			                              productRepository.save(oldprod);
			                              newprod=this.toDto(oldprod);
				});
		
		return newprod;
	}
	public ProductDTO toDto(Product product) {
		ProductDTO pDto = new ProductDTO();
		
		pDto.setProductId(product.getProductId());
		pDto.setImageName(product.getImageName());
		pDto.setProductName(product.getProductName());
		pDto.setProductDesc(product.getProductDesc());
		pDto.setProductPrize(product.getProductPrize());
		pDto.setProductQuantity(product.getProductQuantity());
		pDto.setLive(product.isLive());
		pDto.setStock(product.isStock());
		
		CategoryDTO catdto = new CategoryDTO();
		catdto.setCategoryId(product.getCategory().getCategoryId());
		catdto.setTitle(product.getCategory().getTitle());
		pDto.setCategorydto(catdto);
		return pDto;
	}
	public Product toEntity(ProductDTO product) {
		Product p = new Product();
		
		p.setProductId(product.getProductId());
		p.setImageName(product.getImageName());
		p.setProductName(product.getProductName());
		p.setProductDesc(product.getProductDesc());
		p.setProductQuantity(product.getProductQuantity());
		p.setProductPrize(product.getProductPrize());
		p.setLive(product.isLive());
		p.setStock(product.isStock());
		
		return p;
	}
	
	public List<ProductDTO> findProductByCategory(int categoryId){
		
         Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category Id not found"));
		 List<Product> findByCategory = this.productRepository.findByCategory(category);
		 return findByCategory.stream().map(cat -> toDto(cat)).collect(Collectors.toList());
	}
}
