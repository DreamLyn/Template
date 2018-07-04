package com.lyn.modules.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyn.modules.user.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
