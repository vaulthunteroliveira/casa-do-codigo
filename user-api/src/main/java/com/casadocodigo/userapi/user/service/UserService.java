package com.casadocodigo.userapi.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casadocodigo.userapi.user.dto.UserDTO;
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
	
	
}
