package com.casadocodigo.productapi.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casadocodigo.productapi.product.dto.ProductDTO;
import com.casadocodigo.productapi.product.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<ProductDTO> getProductByCategoryId(Long categoriaId) {
		return productRepository.getProductByCategory(categoriaId)
				.stream()
				.map(ProductDTO::convert)
				.collect(Collectors.toList());
	

	}
	
	
	
}
