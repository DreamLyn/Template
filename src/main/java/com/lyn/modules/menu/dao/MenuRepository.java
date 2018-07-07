package com.lyn.modules.menu.dao;

import com.lyn.modules.menu.entity.Menu;
import com.lyn.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long>{
	
	/**
	 * 返回用户信息
	 * @param username
	 * @return
	 */
	Optional<User> findByUsername(String username);
}
