package com.casadocodigo.productapi.product.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.casadocodigo.productapi.category.dto.CategoryDTO;
import com.casadocodigo.productapi.product.entity.Product;

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
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	@NotBlank
	private String productIdentifier;
	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	@NotNull
	private BigDecimal preco;
	@NotNull
	private CategoryDTO categoryDTO;
	
	public static ProductDTO convert(Product product) {
		return ProductDTO.builder()
				.nome(product.getNome())
				.preco(product.getPreco())
				.productIdentifier(product.getProductIdentifier())
				.descricao(product.getDescricao())
				.categoryDTO(CategoryDTO.convert(product.getCategory()))
				.build();
	}
	
	
	
}
