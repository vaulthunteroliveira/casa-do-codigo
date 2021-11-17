package com.casadocodigo.productapi.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casadocodigo.productapi.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	

	
	@Query(value = "select p "
			+ "from Product p "
			+ "join Category c on p.category.id = c.id "
			+ "where c.id = :categoryId ")
	List<Product> getProductByCategory(@Param("categoryId") long categoryId);
}
