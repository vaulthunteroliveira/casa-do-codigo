package com.casadocodigo.productapi.product.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.casadocodigo.productapi.category.entity.Category;

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
@Table(name = "cc_product")
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	private String productIdentifier;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
}
