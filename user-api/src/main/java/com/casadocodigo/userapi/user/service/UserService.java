package com.casadocodigo.userapi.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casadocodigo.userapi.user.dto.UserDTO;
import com.casadocodigo.userapi.user.entity.User;
import com.casadocodigo.userapi.user.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<UserDTO> getAll() {
		return userRepository.findAll()
				.stream()
				.map(UserDTO::convert)
				.collect(Collectors.toList());
	}
	
	public UserDTO findById(Long id) {
		Optional<User> usuario = userRepository.findById(id);
		if(usuario.isPresent())
			return UserDTO.convert(usuario.get());
		
		return null;
	}
	
	public UserDTO save(UserDTO userDTO) {
		User user = userRepository.save(User.convert(userDTO));
		return UserDTO.convert(user);
	}
	
	public boolean delete(Long id) {
		Optional<User> usuario = userRepository.findById(id);
		if(usuario.isPresent()) {
			userRepository.delete(usuario.get());
			return true;
		}
		throw new RuntimeException("usuário não encontrado!");
	}
	
	public UserDTO findByCpf(String cpf) {
		User usuario = userRepository.findByCpf(cpf);
		if(usuario != null)
			return UserDTO.convert(usuario);
		
		return null;
	}
	
	public List<UserDTO> queryByName(String name) {
		return userRepository.findByNomeLike(name.concat("%"))
				.stream()
				.map(UserDTO::convert)
				.collect(Collectors.toList());
	}
	
	
	
	
	
	
	
}
