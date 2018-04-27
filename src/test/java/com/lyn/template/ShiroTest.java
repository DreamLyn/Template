package com.lyn.template;


import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;


@Slf4j
public class ShiroTest {
    @Test
    public void shiroBase() {
        //获取安全管理器
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        //设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        //获取Subject对象
        Subject currentUser=SecurityUtils.getSubject();
        //获取session
        Session session=currentUser.getSession();
        session.setAttribute("name","name");
        if(currentUser.isAuthenticated()==false){
            //usernamepasswordtoken
            UsernamePasswordToken token=new UsernamePasswordToken("root","secret");
            token.setRememberMe(true);
            try{
                currentUser.login(token);currentUser.login(token);
                log.info("登陆成功");
                //用户是否有相应角色
                log.info("是否拥有角色admin:"+currentUser.hasRole("admin"));
                log.info("是否拥有角色user:"+currentUser.hasRole("user"));
                //用户是否有相应权限
                log.info("是否拥有权限lightsaber:"+currentUser.isPermitted("lightsaber"));
            }catch (UnknownAccountException e){
                log.info("账户不存在");
            }catch (IncorrectCredentialsException e){
                log.info("密码错误");
            }
        }
    }
}
