package com.linno.cn.strategy;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @Author: zhengcong
 * @Desc: 动力商城用户登录策略
 */
@Component("system:powerMall")
public class PowerMallUserLoginStrategy implements LoginStrategy {

    @Override
    public UserDetails realLogin(String loginAct) {
        return null;
    }
}
