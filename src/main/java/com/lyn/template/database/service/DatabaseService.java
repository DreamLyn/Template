package com.lyn.template.database.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyn.template.common.config.SystemConfig;
import com.lyn.template.database.dao.SystemInfoRepository;
import com.lyn.template.database.entity.SystemInfo;
import com.lyn.template.ui.dao.MenuItemRepository;
import com.lyn.template.ui.entity.MenuItem;

@Service
@Transactional
public class DatabaseService implements InitializingBean {

	@Autowired
	private SystemInfoRepository systemInfoRepository;
	@Autowired
	private SystemConfig systemConfig;
	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		Optional<SystemInfo> systemInfoO = systemInfoRepository.findById((long) 1);
		if (systemInfoO.isPresent()) {
			if (!systemConfig.getVersion().equals(systemInfoO.get().getVersion())) {
				// 如果不相等
				SystemInfo systemInfo = new SystemInfo();
				systemInfo.setId(1);
				systemInfo.setVersion(systemConfig.getVersion());
				systemInfoRepository.saveAndFlush(systemInfo);
				updateDatabase();
			}
		} else {
			// 如果数据库为空,则插入数据
			SystemInfo systemInfo = new SystemInfo();
			systemInfo.setId(1);
			systemInfo.setVersion(systemConfig.getVersion());
			systemInfoRepository.saveAndFlush(systemInfo);
			updateDatabase();
		}
	}

	/**
	 * 更新数据库
	 */
	private void updateDatabase() {
		List<MenuItem> menuItems = new ArrayList<>();

		MenuItem menuItem = new MenuItem();
		menuItem.setId(0);
		menuItem.setLevel(0);
		menuItem.setMenuValue("IT工具");
		menuItem.setParentId(-1);
		menuItem.setSequence(0);
		menuItem.setUrl("it/websocket.html");
		menuItems.add(menuItem);
	///////////////////////////////////////////////////////////////////////////	
		menuItem = new MenuItem();
		menuItem.setId(1);
		menuItem.setLevel(1);
		menuItem.setMenuValue("WebSocket工具");
		menuItem.setParentId(0);
		menuItem.setSequence(0);
		menuItem.setUrl("it/websocket.html");
		menuItems.add(menuItem);
		
		menuItem = new MenuItem();
		menuItem.setId(2);
		menuItem.setLevel(1);
		menuItem.setMenuValue("编码类工具");
		menuItem.setParentId(0);
		menuItem.setSequence(1);
		menuItem.setUrl("");
		menuItems.add(menuItem);
		/*******************************************/
		menuItem = new MenuItem();
		menuItem.setId(3);
		menuItem.setLevel(2);
		menuItem.setMenuValue("图片转Base64编码");
		menuItem.setParentId(2);
		menuItem.setSequence(0);
		menuItem.setUrl("it/image2base64.html");
		menuItems.add(menuItem);
		
		menuItem = new MenuItem();
		menuItem.setId(4);
		menuItem.setLevel(2);
		menuItem.setMenuValue("字符串加解密");
		menuItem.setParentId(2);
		menuItem.setSequence(1);
		menuItem.setUrl("it/encrypt.html");
		menuItems.add(menuItem);
	///////////////////////////////////////////////////////////////////////	
		menuItem = new MenuItem();
		menuItem.setId(5);
		menuItem.setLevel(0);
		menuItem.setMenuValue("金融工具");
		menuItem.setParentId(-1);
		menuItem.setSequence(1);
		menuItem.setUrl("it/websocket.html");
		menuItems.add(menuItem);

		menuItemRepository.deleteAll();
		menuItemRepository.saveAll(menuItems);
	}
}
