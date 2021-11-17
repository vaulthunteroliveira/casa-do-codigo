package com.casadocodigo.productapi.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.productapi.product.dto.ProductDTO;
import com.casadocodigo.productapi.product.service.ProductService;

@RestController("/")
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/product/category/{categoryId}")
	private List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {
		return productService.getProductByCategoryId(categoryId);
				
	}

}
