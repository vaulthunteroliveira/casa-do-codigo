package com.casadocodigo.productapi.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casadocodigo.productapi.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
