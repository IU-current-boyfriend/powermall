package com.linno.cn.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * HTTP枚举
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum HTTPEnum {

    // 获取资源成功
    GET_RESOURCE_SUCCESS(200, "获取资源成功"),

    // 获取资源失败
    SERVER_BAD(500, "服务器内部出现问题"),

    // 无效的凭证
    NO_VALID_AUTHORIZATION(401, "无效的凭证信息"),
    // 用户无权限访问
    USER_NO_ACCESS(403, "该用户没有权限访问该资源");

    private int code;
    private String msg;
}
