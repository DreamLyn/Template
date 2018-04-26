package com.lyn.template.authority.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyn.template.authority.entity.Role;
import com.lyn.template.authority.entity.User;
import com.lyn.template.authority.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
	
	Optional<UserRole> findByUserId(long userId);
}
