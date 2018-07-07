package com.lyn.modules.menu.controller;

import com.lyn.modules.common.data.STATUS;
import com.lyn.modules.common.schema.ResponseBean;
import com.lyn.modules.menu.entity.Menu;
import com.lyn.modules.menu.service.MenuService;
import com.lyn.modules.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 获取所有菜单,应根据用户所属角色的权限获取相应的菜单项,后期考虑
     *
     * @return
     */
    @PostMapping("/menu/get/all")
    public ResponseBean getAllMenu() {
        ResponseBean responseBean = new ResponseBean();
        List<Menu> menus = menuService.getAllMenu();
        responseBean.setCode(STATUS.SUCCESS);
        responseBean.setData(menus);
        return responseBean;
    }


}
