package com.linno.cn.strategy;


import com.linno.cn.contants.AuthConstants;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @Author: zhengcong
 * @Desc: 动力商城用户登录策略
 */
@Component(AuthConstants.SYSTEM_POWER_MALL)
public class PowerMallUserLoginStrategy implements LoginStrategy {

    @Override
    public UserDetails realLogin(String loginAct) {
        return null;
    }
}
