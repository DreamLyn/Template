package com.lyn.template.authority.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyn.template.authority.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
