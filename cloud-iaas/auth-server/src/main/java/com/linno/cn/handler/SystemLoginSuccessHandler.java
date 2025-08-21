package com.linno.cn.handler;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.linno.cn.contants.AuthConstants;
import com.linno.cn.model.LoginResultModel;
import com.linno.cn.model.LoginUserModel;
import com.linno.cn.result.RsResult;
import com.linno.cn.utils.ResponseUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhengcong
 * @Desc: 系统登录成功处理器
 */
@Component
public class SystemLoginSuccessHandler implements AuthenticationSuccessHandler {


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        /**
         * 系统登录成功处理器需要做什么事情？
         *  用户能到这一步,说明已经通过验证了。
         *  1. 生成用户凭证
         *  2. 将凭证保存到redis中
         *  3. 将信息响应给前端
         */

        LoginUserModel loginUser = (LoginUserModel) authentication.getPrincipal();

        // 设置响应体格式
        // response.setContentType(AuthConstants.CONTENT_JSON_TYPE);
        // response.setCharacterEncoding(AuthConstants.CHARACTER_UTF_8);

        // 利用UUID生成用户唯一的凭证
        String accessToken = IdUtil.randomUUID();

        // 将LoginUser对象转为Json对象
        String loginUserJson = JSONUtil.toJsonStr(loginUser);

        // 将用户的凭证保存在redis中,半小时过期;accessToken格式:Auth_login:系统类型userId
        stringRedisTemplate.opsForValue().set(AuthConstants.LOGIN_TOKEN_PREFIX + accessToken, loginUserJson, 30, TimeUnit.MINUTES);

        // 封装登录结果集响应对象
        LoginResultModel loginResultModel = new LoginResultModel();
        loginResultModel.setAccessToken(accessToken);
        loginResultModel.setPermissions(loginUser.getPerms());


        // 将结果响应给前端
        // PrintWriter printWriter = response.getWriter();
        // printWriter.print(RsResult.OK(loginResultModel));
        // printWriter.flush();
        // printWriter.close();


        ResponseUtil.write(response, RsResult.OK(loginResultModel));
    }
}
