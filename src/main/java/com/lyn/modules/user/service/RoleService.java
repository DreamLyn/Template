package com.lyn.modules.user.service;

import java.util.ArrayList;
import java.util.List;

import com.lyn.modules.user.dao.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyn.modules.user.entity.Role;


@Service
public class RoleService{
	@Autowired
	private RoleRepository roleRepository;
	
	/**
	 * 根据用户ID，获取此用户的角色
	 * @param userId
	 * @return
	 */
	public List<Role> getRoleByUserId(long userId){
//		return roleRepository.findByUserRole_userId(userId);
		return new ArrayList<>();
	}
}
