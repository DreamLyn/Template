package com.lyn.template.ui.controller;

import java.awt.Dialog.ModalExclusionType;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lyn.template.common.config.SystemConfig;
import com.lyn.template.ui.entity.MenuItem;
import com.lyn.template.ui.service.MenuItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect // 1
@Component // 2
public class MenuAspectj {
	@Autowired
	private MenuItemService menuItemService;
	@Autowired
	private SystemConfig systemConfig;
	
	@Pointcut("execution(* com.lyn.template.ui.controller..*(..))")
	public void controller() {
	}
	@Before("controller()")
	public void controllerAfter(JoinPoint point) {
		Object[] args = point.getArgs();
		Model model;
		if (args != null && args.length > 0) {
            for(int i=0;i<args.length;i++) {
            	System.out.println(args[i].getClass());
            	if(args[i].getClass()==BindingAwareModelMap.class) {
            		model=(Model) args[i];
            		/**
            		 * 添加网站名称
            		 */
            		model.addAttribute("name", systemConfig.getName());
            		/**
            		 * 添加菜单
            		 */
            		List<MenuItem> menuItems=menuItemService.getMenusLevel0();
            		model.addAttribute("menuItems", menuItems);
            		
            		
            		
            	}
            }
        }
	}
}
