package com.linno.cn.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 请求对象工具类
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtil {
   // 默认响应体的响应类型及字符集编码
    private String contentType;
    private String charset;

}
