package com.lyn.template.authority.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyn.template.authority.entity.User;
import com.lyn.template.authority.service.UserService;
import com.lyn.template.common.util.JWTUtil;

@Service
public class ShiroRealm  extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }


    /**
     * 用户权限认证,如checkRole,checkPermission
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JWTUtil.getUsername(principals.toString());
        User user = userService.getUserByUsername(username);
        if(user!=null) {
        	SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addRole("");
            Set<String> permission = new HashSet<>();
            simpleAuthorizationInfo.addStringPermissions(permission);
            return simpleAuthorizationInfo;
        }else {
        	throw new AuthenticationException("用户名不存在");
        }
    }


    /**
     * 用户身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        User userBean = new User();//.getUser(username);
        if (userBean == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (! JWTUtil.verify(token, username, userBean.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
