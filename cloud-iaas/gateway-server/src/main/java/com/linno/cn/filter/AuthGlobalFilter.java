package com.linno.cn.filter;

import cn.hutool.json.JSONUtil;
import com.linno.cn.config.AllowUrlsConfig;
import com.linno.cn.contants.AuthConstants;
import com.linno.cn.enums.HTTPEnum;
import com.linno.cn.result.RsResult;
import jakarta.annotation.Resource;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Resource
    private AllowUrlsConfig allowUrlsConfig;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求、响应对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        // 获取当前请求地址
        // 判断当前请求地址是否处于白名单列表,如果存在则不做限制
        if (this.includeAllowUrls(request.getPath().toString())) return chain.filter(exchange);
        // 存在凭证，并且凭证没有过期
        if (this.validateAuthorization(request) && this.noExpireAuthorization(request)) return chain.filter(exchange);
        // 无效的token,创建结果集
        RsResult rsResult = RsResult.builder().code(HTTPEnum.NO_VALID_AUTHORIZATION.getCode())
                .msg(HTTPEnum.NO_VALID_AUTHORIZATION.getMsg())
                .data(null)
                .build();
        // 将对象转为JSON字符串对象，然后再转为byte[]数组
        String rsJsonStr = JSONUtil.toJsonStr(rsResult);
        // 将JSON字符串转为Filter函数需要的数据类型
        DataBuffer bufferFactory = response.bufferFactory().wrap(rsJsonStr.getBytes());
        // 返回结果
        return response.writeWith(Mono.just(bufferFactory));
    }

    @Override
    public int getOrder() {
        return -5; // 拦截器数值越低，优先级越高
    }


    /**
     * 请求对象中获取凭证字段
     * @param request 请求对象
     * @return 字符串
     */
    private String getHeaderField(ServerHttpRequest request) {
        return request.getHeaders().getFirst(AuthConstants.AUTHORIZATION);
    }



    /**
     * 判断凭证的合法性：
     * 1. 请求中存在Authorization字段
     * 2. Authorization字段以Bearer开头
     * 3. 凭证后面不能空字符串
     * @param request 请求对象
     * @return 是否存在有效的token凭证
     */
    private Boolean validateAuthorization(ServerHttpRequest request) {
        String authorization = this.getHeaderField(request);
        String token = authorization.replaceAll(AuthConstants.BEARER_PREFIX, "");
        // 存在authorization字段、以Bearer开头、存在token
        return StringUtils.hasText(authorization) && authorization.startsWith(AuthConstants.BEARER_PREFIX) && StringUtils.hasText(token);
    }


    /**
     * 判断token凭证是否过期
     * @param request 请求对象
     * @return boolean布尔值
     */
    private Boolean noExpireAuthorization(ServerHttpRequest request) {
        if (!this.validateAuthorization(request)) return false;
        String authorization = this.getHeaderField(request);
        String token = authorization.replaceAll(AuthConstants.BEARER_PREFIX, "");
        return stringRedisTemplate.hasKey(AuthConstants.LOGIN_TOKEN_PREFIX + token);
    }



    /**
     * 判断请求路径是否存在与白名单之中
     * @param path 请求路径
     * @return boolean值
     */
    private Boolean includeAllowUrls(String path) {
        return allowUrlsConfig.getAllowUrls().contains(path);
    }
}
