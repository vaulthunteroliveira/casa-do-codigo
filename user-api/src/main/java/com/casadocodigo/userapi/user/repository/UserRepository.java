package com.casadocodigo.userapi.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casadocodigo.userapi.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByCpf(String cpf);
	
	List<User> queryByNomeLike(String nome);
	
	List<User> findByNomeLike(String nome);

}
