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
    public static final String CONTENT_JSON_TYPE = "application/json;charset=UTF-8";


    public static final String CHARACTER_UTF_8 = "UTF-8";

    /**
     * 系统标识符
     */
    public static final String SYSTEM_MARK = "loginType";

    /**
     * 商城系统标识
     */
    public static final String SYSTEM_POWER_MALL = "system:powerMall";


    /**
     * 后台系统标识
     */
    public static final String SYSTEM_POWER_BOSS = "system:powerBoss";


}
