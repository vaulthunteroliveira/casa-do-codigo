package com.casadocodigo.userapi.user.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.userapi.user.dto.UserDTO;
import com.casadocodigo.userapi.user.service.UserService;

@RestController("/")
public class UserController {
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		return userService.getAll();
	}
	
	@GetMapping("/user/cpf/{cpf}")
	public UserDTO getUserFiltro(@PathVariable String cpf) {
		return userService.findByCpf(cpf); 
	}
	
	@PostMapping("/newUser")
	public UserDTO insertUser(@RequestBody UserDTO userDTO) {
		userDTO.setDataCadastro(LocalDateTime.now());
		return userService.save(userDTO); 
	}
	
	@DeleteMapping("/removeUser/{id}")
	public boolean remove(@PathVariable Long id) {
		return userService.delete(id);
	}
	
	@GetMapping("/user/{id}")
	public UserDTO findById(@PathVariable Long id) {
		return userService.findById(id);
	}

	@GetMapping("/user/search")
	public List<UserDTO> queryByName(@RequestParam(name="nome", required = true) String nome) {
		return userService.queryByName(nome);
	}

}
