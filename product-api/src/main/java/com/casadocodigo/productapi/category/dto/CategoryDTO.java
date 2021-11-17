package com.casadocodigo.productapi.category.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	
	@NotNull
	private Long id;
	@NotBlank
	private String nome;

	public static CategoryDTO convert(Category category) {
		return CategoryDTO.builder()
				.id(category.getId())
				.nome(category.getNome())
				.build();
	}



}
