package com.linno.cn.factory;

import com.linno.cn.strategy.LoginStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhengcong
 * @Desc: 用户登录策略工厂
 */
@Component
public class UserLoginStrategyFactory {

    private final Map<String, LoginStrategy> strategies = new HashMap<>();

    /**
     *
     * @param loginType 系统类型
     * @return 返回登录策略
     */
    public LoginStrategy getInstance(String loginType) {
        return strategies.get(loginType);
    }
}
