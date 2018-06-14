package com.lyn.template.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lyn.template.ui.entity.MenuItem;
import com.lyn.template.ui.service.MenuItemService;

@Controller
public class MenuController {
	@Autowired
	private MenuItemService menuItemService;
	/**
	 * 
	 * @return
	 */
	@GetMapping("index.html")
	public String index() {
		return "index";
	}

	/**
	 * websocket调试助手
	 * websocket属于第一个菜单,目前使用默认
	 * @return
	 */
	@GetMapping("websocket.html")
	public String websocket(Model model) {
		List<MenuItem> menuItems=menuItemService.getMenusLevel1(0);
		model.addAttribute("menuItemsVices", menuItems);
		return "it/websocket";
	}

	/**
	 * 图片转base64编码
	 * 
	 * @return
	 */
	@GetMapping("image2base64.html")
	public String image2base64() {
		return "it/image2base64";
	}

	/**
	 * 在线加密与解密
	 * 
	 * @return
	 */
	@GetMapping("encrypt.html")
	public String encrypt() {
		return "it/encrypt";
	}

}
