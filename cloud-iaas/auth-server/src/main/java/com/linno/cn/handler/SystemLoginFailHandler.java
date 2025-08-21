package com.linno.cn.handler;

import com.linno.cn.exception.LoginAuthException;
import com.linno.cn.result.RsResult;
import com.linno.cn.utils.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: zhengcong
 * @Desc: 系统用户登录失败处理器
 */
@Component
public class SystemLoginFailHandler implements AuthenticationFailureHandler {

    @Resource
    private LoginAuthException loginAuthException;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 根据策略选择异常信息实例对象
        RsResult loginExceptionInstance = loginAuthException.getLoginExceptionInstance(AuthenticationException.class);
        // 将信息实例对象写入响应体中
        ResponseUtil.write(response, loginExceptionInstance);

    }
}
