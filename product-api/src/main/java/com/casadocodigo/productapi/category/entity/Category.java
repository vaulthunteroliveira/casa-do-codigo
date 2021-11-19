package com.casadocodigo.productapi.category.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public Category(Long id) {
		this.id = id;
	}
}
