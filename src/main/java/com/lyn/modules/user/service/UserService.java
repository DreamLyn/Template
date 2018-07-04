package com.lyn.modules.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyn.modules.user.dao.UserRepository;
import com.lyn.modules.user.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 根据用户名获取用户信息
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username) {
		Optional<User> optional = userRepository.findByUsername(username);
		return optional.isPresent()?optional.get():null;
	}
	
}
