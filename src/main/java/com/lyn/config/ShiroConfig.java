package com.lyn.config;

import com.lyn.component.redis.RedisSessionDao;
import com.lyn.component.redis.RedisSessionManager;
import com.lyn.component.shiro.SysShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;

//@Configuration
public class ShiroConfig {
//    /**
//     * Shiro过滤器
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public ShiroFilterFactoryBean factory(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//        //注意过滤器配置顺序 不能颠倒
//        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
//        filterChainDefinitionMap.put("/logout", "logout");
//        // 配置不会被拦截的链接 顺序判断
//        filterChainDefinitionMap.put("/ajaxLogin", "anon");
//        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/**", "authc");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * 凭证匹配器(密码校验交给了Shiro的SimpleAuthenticationInfo处理)
//     * @return
//     */
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
//        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
//        return hashedCredentialsMatcher;
//    }
//
//    /**
//     * 设定realm中校验规则
//     * @return
//     */
//    @Bean
//    public SysShiroRealm sysShiroRealm() {
//        SysShiroRealm sysShiroRealm = new SysShiroRealm();
//        sysShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return sysShiroRealm;
//    }
//
//
//    /**
//     * 安全管理器
//     * 疑问:在此处调用  sysShiroRealm()后,会不会重新创建一个新的实例.
//     * 解答:当@Bean对彼此的依赖，表达这种依赖很简单，只要有一个Bean的方法调用另一个,如下.
//     * @return
//     */
//	@Bean
//    public SecurityManager securityManager(SysShiroRealm sysShiroRealm, SessionManager sessionManager) {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        // 使用自己的realm
//        securityManager.setRealm(sysShiroRealm);
//
//        // 自定义session管理 使用redis
//        securityManager.setSessionManager(sessionManager);
//        // 自定义缓存实现 使用redis
////        securityManager.setCacheManager(cacheManager());
//
//        //session中不保存subject信息
//        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
//        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
//        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
//        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
//        securityManager.setSubjectDAO(subjectDAO);
//        return securityManager;
//    }
//
//    /**
//     * 自定义SessionManager
//     * @return
//     */
//    @Bean
//    public SessionManager sessionManager(RedisSessionDao redisSessionDao) {
//        redisSessionDao.setPrefix("shiro-session:");
//        //注意中央缓存有效时间要比本地缓存有效时间长
//        redisSessionDao.setSeconds(1800);
//
//        RedisSessionManager redisSessionManager = new RedisSessionManager();
//        redisSessionManager.setSessionDAO(redisSessionDao);
//        //设置session过期时间为1小时(单位：毫秒)，默认为30分钟
//        redisSessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
//        redisSessionManager.setSessionIdUrlRewritingEnabled(false);
//        redisSessionManager.setSessionValidationSchedulerEnabled(true);
//        redisSessionManager.setSessionDAO(redisSessionDao);
//        return redisSessionManager;
//    }
//
//    /**
//     * 开启shiro aop注解支持.
//     * 使用代理方式;所以需要开启代码支持;
//     *
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//
//    /**
//     * 注册全局异常处理
//     * @return
//     */
//    @Bean(name = "exceptionHandler")
//    public HandlerExceptionResolver handlerExceptionResolver() {
//        return new SysExceptionHandler();
//    }
}
