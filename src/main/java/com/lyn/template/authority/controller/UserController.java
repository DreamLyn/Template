package com.lyn.template.authority.controller;


import com.lyn.template.authority.entity.User;
import com.lyn.template.authority.service.UserService;
import com.lyn.template.common.data.SystemConfig;
import com.lyn.template.common.schema.ResponseBean;
import com.lyn.template.common.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SystemConfig systemConfig;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResponseBean login(String username, String password) {
        // 1、创建Subject实例
        Subject currentUser = SecurityUtils.getSubject();
        // 2、判断当前用户是否登陆
        if (currentUser.isAuthenticated() == false) {
            // 3、将用户名和密码封装成UsernamePasswordToken
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // 4、登陆
            try {
                currentUser.login(token);
                return new ResponseBean(systemConfig.getSuccess(), "登陆成功", JWTUtil.sign(username, password));
            } catch (IncorrectCredentialsException e) {
                throw new IncorrectCredentialsException("密码错误");
            } catch (UnknownAccountException e){
                throw new UnknownAccountException("没有此用户");
            }
        } else {
            return new ResponseBean(systemConfig.getSuccess(), "登陆成功", JWTUtil.sign(username, password));
        }
    }
}
