package com.lyn.template.authority.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lyn.template.authority.dao.UserRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lyn.template.authority.entity.User;

@RestController
public class UserController {

	@Autowired 
	private UserRepository userInfoRepository;
	
	@RequestMapping(value="/getUserInfos")
	public List<User> getUserInfos() {
		
		return userInfoRepository.findAll();
	}
}
