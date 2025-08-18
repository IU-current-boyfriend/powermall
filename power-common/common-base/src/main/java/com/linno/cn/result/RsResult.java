package com.linno.cn.result;

import com.linno.cn.enums.HTTPEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * http响应结果集对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RsResult {
    private int code;
    private String msg;
    private Object data;

    public static RsResult OK() {
        return RsResult.builder()
                .code(HTTPEnum.GET_RESOURCE_SUCCESS.getCode())
                .msg(HTTPEnum.GET_RESOURCE_SUCCESS.getMsg())
                .data(null)
                .build();
    }

    public static RsResult OK(Object data) {
        return RsResult.builder()
                .code(HTTPEnum.GET_RESOURCE_SUCCESS.getCode())
                .msg(HTTPEnum.GET_RESOURCE_SUCCESS.getMsg())
                .data(data)
                .build();
    }

    public static RsResult OK(String msg, Object data) {
        return RsResult.builder()
                .code(HTTPEnum.GET_RESOURCE_SUCCESS.getCode())
                .msg(msg)
                .data(data)
                .build();
    }

    public static RsResult Fail() {
        return RsResult.builder()
                .code(HTTPEnum.SERVER_BAD.getCode())
                .msg(HTTPEnum.SERVER_BAD.getMsg())
                .data(null)
                .build();
    }

    public static RsResult Fail(int code, String msg) {
        return  RsResult.builder()
                .code(code)
                .msg(msg)
                .data(null)
                .build();
    }
}
