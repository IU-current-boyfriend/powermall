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
    USER_NO_ACCESS(403, "该用户没有权限访问该资源"),

    // 用户名或者密码错误
    USER_BAD_CREDENTIAL(20001, "用户名或者密码错误"),

    // 该用户不存在
    USER_NOT_FOUND(20002, "用户不存在"),

    // 用户账号状态异常
    USER_STATUS_EXCEPTION(20003, "用户账号状态异常,请联系管理员"),

    // 服务器内部权限异常
    INTERNAL_SERVICE_BAD(20004, "服务器内部权限异常,请联系管理员");



    private int code;
    private String msg;
}
