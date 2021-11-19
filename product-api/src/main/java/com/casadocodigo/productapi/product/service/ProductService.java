package com.casadocodigo.productapi.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casadocodigo.productapi.product.dto.ProductDTO;
import com.casadocodigo.productapi.product.entity.Product;
import com.casadocodigo.productapi.product.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<ProductDTO> getAll(){
		return productRepository.findAll()
				.stream()
				.map(ProductDTO::convert)
				.collect(Collectors.toList());
	}
	
	public List<ProductDTO> getProductByCategoryId(Long categoriaId) {
		return productRepository.getProductByCategory(categoriaId)
				.stream()
				.map(ProductDTO::convert)
				.collect(Collectors.toList());
	}
	
	public ProductDTO findByProductIdentifier(String productIdentifier) {
		
		Product product = productRepository.findByProductIdentifier(productIdentifier);
		
		if(product != null) {
			return ProductDTO.convert(product); 
		}
		
		return null;
	}
	
	public ProductDTO save(ProductDTO productDTO) {

		Product product = productRepository.save(Product.convert(productDTO));
		
		return ProductDTO.convert(product);
	}
	
	public boolean delete(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			 productRepository.delete(product.get());
			 return true;
		} 
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
