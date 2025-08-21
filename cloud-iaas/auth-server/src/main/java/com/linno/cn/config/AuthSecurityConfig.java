package com.linno.cn.config;

import com.linno.cn.contants.ApiConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

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

    @Resource
    private AuthenticationSuccessHandler systemLoginSuccessHandler;

    @Resource
    private AuthenticationFailureHandler systemLoginFailureHandler;

    @Resource
    private LogoutSuccessHandler systemLogoutSuccessHandler;

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
                .loginProcessingUrl(ApiConstants.POWER_SYSTEM_LOGIN_API) // 登录请求Api的地址
                .successHandler(systemLoginSuccessHandler) // 登录请求成功处理器
                .failureHandler(systemLoginFailureHandler); // 登录失败处理器
        // 配置登出相关信息
        http.logout()
                .logoutUrl(ApiConstants.POWER_SYSTEM_LOGOUT_API) // 登出请求Api地址
                .logoutSuccessHandler(systemLogoutSuccessHandler); // 登出请求成功处理器

        // 除了登录与登出无需认证身份，其它请求都需要认证身份
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
