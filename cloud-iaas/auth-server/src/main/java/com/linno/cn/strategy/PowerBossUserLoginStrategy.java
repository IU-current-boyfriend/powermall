package com.linno.cn.strategy;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @Author: zhengcong
 * @Desc: 动力后台管理系统用户登录策略类
 */
@Component("system:powerBoss")
public class PowerBossUserLoginStrategy implements LoginStrategy {

    @Override
    public UserDetails realLogin(String loginAct) {
        return null;
    }
}
