package com.lyn.template.authority.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyn.template.authority.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	/**
	 * 返回用户信息
	 * @param username
	 * @return
	 */
	Optional<User> findByUsername(String username);
}
