package com.lyn.modules.user.dao;

import java.util.Optional;

import com.lyn.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	/**
	 * 返回用户信息
	 * @param username
	 * @return
	 */
	Optional<User> findByUsername(String username);
}
