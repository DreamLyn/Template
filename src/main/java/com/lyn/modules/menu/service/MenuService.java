package com.lyn.modules.menu.service;

import com.lyn.modules.menu.dao.MenuRepository;
import com.lyn.modules.menu.entity.Menu;
import com.lyn.modules.user.dao.UserRepository;
import com.lyn.modules.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MenuService {
	@Autowired
	private MenuRepository menuRepository;


	/**
	 * 获取所有menu
	 * @return
	 */
	public List<Menu> getAllMenu(){
		return menuRepository.findAll();
	}
	




}