package com.linno.cn.contants;

/**
 * token凭证的常量类
 */
public class AuthConstants {

    /**
     * token凭证请求头字段
     */
    public static final String AUTHORIZATION = "Authorization";

    /**
     * token凭证前缀
     */
    public static final String BEARER_PREFIX = "Bearer";


    /**
     * redis中token凭证的前缀
     */
    public static final String LOGIN_TOKEN_PREFIX = "Auth_login:";


    /**
     * Content-Type标识符
     */
    public static final String CONTENT_TYPE = "Content-Type";


    public static final String JSON_TYPE_UTF_8 = "application/json;charset=UTF-8";
}
