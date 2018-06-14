package com.lyn.template.ui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyn.template.ui.dao.MenuItemRepository;
import com.lyn.template.ui.entity.MenuItem;


@Service
public class MenuItemService{
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	/**
	 * 获取主菜单
	 * @return
	 */
	public List<MenuItem> getMenusLevel0(){
		return menuItemRepository.findByLevelOrderBySequenceAsc(0);
	}
	/**
	 * 获取副级菜单
	 * @return
	 */
	public List<MenuItem> getMenusLevel1(long parentId){ 
		List<MenuItem> menuItems=menuItemRepository.findByLevelAndParentIdOrderBySequenceAsc(1,parentId);
		for(MenuItem menuItem:menuItems) {
			menuItem.setMenuItems(menuItemRepository.findByLevelAndParentIdOrderBySequenceAsc(2, menuItem.getId()));
		}
		return menuItems;
	}
}
