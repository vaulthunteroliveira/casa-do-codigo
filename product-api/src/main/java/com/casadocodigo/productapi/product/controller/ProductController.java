package com.casadocodigo.productapi.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.productapi.product.dto.ProductDTO;
import com.casadocodigo.productapi.product.service.ProductService;

@RestController()
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/products")
	public List<ProductDTO> getProducts(){
		return productService.getAll();
	}

	@GetMapping("/product/category/{categoryId}")
	private List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {
		return productService.getProductByCategoryId(categoryId);
				
	}
	
	@GetMapping("/product/{productIdentifier}")
	public ProductDTO getProductByIdentifier(@PathVariable String productIdentifier) {
		return productService.findByProductIdentifier(productIdentifier);
	}
	
	@PostMapping("/product")
	public ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO) {
		return productService.save(productDTO);
	}
	
	@DeleteMapping("/product/{id}")
	public boolean delete(@PathVariable Long id) {
		 return productService.delete(id);
	}
}
