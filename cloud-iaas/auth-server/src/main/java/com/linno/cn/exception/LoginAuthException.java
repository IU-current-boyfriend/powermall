package com.linno.cn.exception;

import com.linno.cn.enums.HTTPEnum;
import com.linno.cn.result.RsResult;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhengcong
 * @Desc: 登录权限异常策略类
 */
@Component
public class LoginAuthException {


    private final Map<Class<? extends AuthenticationException>, RsResult> loginAuthExceptionWrapper = new HashMap<>();

    public LoginAuthException() {
        this.initLoginAuthException();
    }

    public void initLoginAuthException() {
        loginAuthExceptionWrapper.put(BadCredentialsException.class, RsResult.builder()
                .code(HTTPEnum.USER_BAD_CREDENTIAL.getCode())
                .msg(HTTPEnum.USER_BAD_CREDENTIAL.getMsg())
                .data(null)
                .build()
        );
        loginAuthExceptionWrapper.put(UsernameNotFoundException.class, RsResult.builder()
                .code(HTTPEnum.USER_NOT_FOUND.getCode())
                .msg(HTTPEnum.USER_NOT_FOUND.getMsg())
                .data(null)
                .build()
        );
        loginAuthExceptionWrapper.put(InternalAuthenticationServiceException.class, RsResult.builder()
                .code(HTTPEnum.INTERNAL_SERVICE_BAD.getCode())
                .msg(HTTPEnum.INTERNAL_SERVICE_BAD.getMsg())
                .data(null)
                .build());

        loginAuthExceptionWrapper.put(AccountStatusException.class, RsResult.builder()
                .code(HTTPEnum.USER_STATUS_EXCEPTION.getCode())
                .msg(HTTPEnum.USER_STATUS_EXCEPTION.getMsg())
                .data(null)
                .build());
    }


    public RsResult getLoginExceptionInstance(Class<? extends AuthenticationException> e) {
        RsResult instance = loginAuthExceptionWrapper.get(e);
        if (instance == null) {
            return RsResult.Fail();
        }
        return instance;
    }
}
