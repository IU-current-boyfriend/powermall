package com.linno.cn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

/**
 * @Author: zhengcong
 * @Desc: 认证授权中心security配置文件
 *
 */
@Configuration
public class AuthSecurityConfig extends WebSecurityConfigurerAdapter {


    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * @param http 配置http请求
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁止csrf跨站伪造请求
        http.csrf().disable();
        // 禁止cors跨域请求
        http.cors().disable();
        // 关闭session使用策略
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 配置登陆相关信息
        http.formLogin()
                .loginProcessingUrl("") // 登录请求Api的地址
                .successHandler(null) // 登录请求成功处理器
                .failureHandler(null); // 登录失败处理器
        // 配置登出相关信息
        http.logout()
                .logoutUrl("") // 登出请求Api地址
                .logoutSuccessHandler(null); // 登出请求成功处理器

        // 除了登录与登出无需认证身份，其它请求都需要认证身份
        http.authorizeRequests().anyRequest().authenticated();
    }
}
