package com.casadocodigo.userapi.user.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.userapi.user.dto.UserDTO;
import com.casadocodigo.userapi.user.service.UserService;

@RestController("/")
public class UserController {
	
	public static List<UserDTO> usuarios = new ArrayList<>();
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	private String home() {
		return "ednaldo pereira";
	}
	
	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		return userService.getAll();
	}
	
	@GetMapping("/users/{cpf}")
	public UserDTO getUserFiltro(@PathVariable String cpf) {
		
		for (UserDTO userDTO : usuarios) {
			if(userDTO.getCpf().equals(cpf))
				return userDTO;
		}
		
		return null;
	}
	
	@PostMapping("/newUser")
	public UserDTO insertUser(@RequestBody UserDTO userDTO) {
		userDTO.setDataCadastro(LocalDateTime.now());
		usuarios.add(userDTO);
		return userDTO;
	}
	
	@DeleteMapping("/removeUser/{cpf}")
	public boolean remove(@PathVariable String cpf) {
		for (UserDTO userDTO : usuarios) {
			if(userDTO.getCpf().equals(cpf)) {
				usuarios.remove(userDTO);
				return true;
			}
		}
		return false;
	}
	
	@PostConstruct
	private void initiateList() {
		
		UserDTO userDTO1 = UserDTO.builder()
				.nome("Eduardo")
				.cpf("123")
				.endereco("Rua A")
				.email("eduardo@email.com")
				.telefone("1234-3454")
				.dataCadastro(LocalDateTime.now())
				.build();
		
		UserDTO userDTO2 = UserDTO.builder()
				.nome("Luiz")
				.cpf("456")
				.endereco("Rua B")
				.email("luiz@email.com")
				.telefone("1234-3454")
				.dataCadastro(LocalDateTime.now())
				.build();
		
		UserDTO userDTO3 = UserDTO.builder()
				.nome("Bruna")
				.cpf("789")
				.endereco("Rua C")
				.email("Bruna@email.com")
				.telefone("1234-3454")
				.dataCadastro(LocalDateTime.now())
				.build();

		usuarios.add(userDTO1);
		usuarios.add(userDTO2);
		usuarios.add(userDTO3);
		
	}
}
