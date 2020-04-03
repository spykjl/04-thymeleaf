package com.karl.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加过滤器
        Map<String, String> filterMap=new LinkedHashMap<>();
        //授权
        filterMap.put("/emp","perms[root]");

        //页面权限
        filterMap.put("/emp/*","authc");
        filterMap.put("/emps","authc");

        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录页
        bean.setLoginUrl("/index.html");

        //未授权页面链接
        bean.setUnauthorizedUrl("/noAuth");

        return bean;
    }


    //创建Security
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();

        manager.setRealm(userRealm);
        return manager;
    }

    //创建realm对象
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    //ShiroDialect 整合thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}