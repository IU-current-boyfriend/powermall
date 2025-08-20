package com.linno.cn.strategy;


import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Author: zhengcong
 * @Desc: 登录策略
 */
public interface LoginStrategy {
    UserDetails realLogin(String loginAct);
}
