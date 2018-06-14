package com.lyn.template.ui.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class MenuItem {
	@Id
	private long id;
	/**
	 * 菜单显示内容
	 */
	private String menuValue;
	/**
	 * 链接
	 */
	private String url;
	/**
	 * 菜单层级
	 */
	private int level;
	/**
	 * 父菜单
	 */
	private long parentId;
	/**
	 * 显示顺序
	 */
	private int sequence;
	
	@Transient    
	private List<MenuItem> menuItems;    
}
