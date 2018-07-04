package com.lyn.component.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lyn.modules.user.entity.Role;
import com.lyn.modules.user.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyn.modules.user.entity.User;
import com.lyn.modules.user.service.UserService;

import javax.annotation.Resource;


public class SysShiroRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;
	@Resource
    private RoleService roleService;
	
    /**
     * 用户权限认证,如checkRole,checkPermission
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user= (User) principals.getPrimaryPrincipal();
        if(user!=null){
            //查询用户角色
            List<Role> roles=roleService.getRoleByUserId(user.getId());
            for(Role role:roles){
                info.addRole(String.valueOf(role.getId()));
            }
            Set<String> permission = new HashSet<>();
            info.addStringPermissions(permission);
            return info;
        }else {
            throw new AuthenticationException("用户名不存在");
        }
    }


    /**
     * 用户身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username= (String) token.getPrincipal();
        User user = userService.getUserByUsername(username);
        if(user == null){
            throw new AuthenticationException("帐号密码错误");
        }

        SimpleAuthenticationInfo sainfo=new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getUsername()),getName());
        return sainfo;
    }

}
