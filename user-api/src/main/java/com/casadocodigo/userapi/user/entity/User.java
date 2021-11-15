package com.casadocodigo.userapi.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.casadocodigo.userapi.user.dto.UserDTO;

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
@Entity
@Table(name = "cc_users")
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private LocalDateTime dataCadastro;
	
	public static User convert(UserDTO userDTO) {
		return User.builder()
				.nome(userDTO.getNome())
				.cpf(userDTO.getCpf())
				.endereco(userDTO.getEndereco())
				.email(userDTO.getEmail())
				.telefone(userDTO.getTelefone())
				.dataCadastro(userDTO.getDataCadastro())
				.build();
	}
}
