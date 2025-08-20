package com.linno.cn.service;

import com.linno.cn.contants.AuthConstants;
import com.linno.cn.factory.UserLoginStrategyFactory;
import com.linno.cn.strategy.LoginStrategy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zhengcong
 * @Desc: 认证鉴权服务中心UserDetailsServer实现类
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Resource
    private UserLoginStrategyFactory loginFactory;

    @Override
    public UserDetails loadUserByUsername(String loginAct) throws UsernameNotFoundException {
        // Security框架抛出loadUserByUsername接口，开发者可在此对用户信息进行校验
        // 因为是多端系统的原因,所以需要对不同系统进行区分,从请求头中获取属性loginType
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        // 获取request请求对象
        HttpServletRequest request = requestAttributes.getRequest();

        // 获取loginType属性
        String loginType = (String) request.getAttribute(AuthConstants.SYSTEM_MARK);

        // 根据类型自动选择登录策略
        LoginStrategy strategy = loginFactory.getInstance(loginType);

        return strategy.realLogin(loginAct);
    }
}
