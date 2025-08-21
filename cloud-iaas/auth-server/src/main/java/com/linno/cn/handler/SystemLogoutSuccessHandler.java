package com.linno.cn.handler;

import com.linno.cn.contants.AuthConstants;
import com.linno.cn.result.RsResult;
import com.linno.cn.utils.ResponseUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: zhengcong
 * @Desc: 系统登出处理器
 */
@Component
public class SystemLogoutSuccessHandler implements LogoutSuccessHandler {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        /**
         * 系统登出的逻辑是什么？能到认证鉴权中心,说明是合法分子
         * 1. 清除redis中该用户缓存数据
         * 2. 返回前端提示信息
         */
        String authorization = request.getHeader(AuthConstants.AUTHORIZATION);
        String accessToken = authorization.replaceFirst(AuthConstants.BEARER_PREFIX, "");
        // 清除redis缓存
        stringRedisTemplate.delete(accessToken);
        // 返回前端提示信息
        ResponseUtil.write(response, RsResult.OK("登出成功~",null));
    }
}
