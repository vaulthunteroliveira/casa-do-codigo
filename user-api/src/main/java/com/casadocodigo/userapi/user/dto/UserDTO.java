package com.casadocodigo.userapi.user.dto;

import java.time.LocalDateTime;

import com.casadocodigo.userapi.user.entity.User;

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
public class UserDTO {

	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private LocalDateTime dataCadastro;
	
	public static  UserDTO  convert(User user) {
		return UserDTO.builder()
				.id(user.getId())
				.nome(user.getNome())
				.cpf(user.getCpf())
				.endereco(user.getEndereco())
				.email(user.getEmail())
				.telefone(user.getTelefone())
				.dataCadastro(user.getDataCadastro())
				.build();
	}
}
