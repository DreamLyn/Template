package com.lyn.template.authority.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyn.template.authority.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);
}
