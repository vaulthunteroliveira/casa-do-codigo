package com.casadocodigo.productapi.category.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.casadocodigo.productapi.product.entity.Product;
import com.casadocodigo.productapi.product.entity.Product.ProductBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode()
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "cc_category")
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
}
