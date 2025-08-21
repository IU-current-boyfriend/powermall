package com.linno.cn.utils;

import com.linno.cn.contants.AuthConstants;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 请求对象工具类
 */
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtil {
   // 默认响应体的响应类型及字符集编码
    private final static String contentType = AuthConstants.CONTENT_JSON_TYPE;
    private final static String charset = AuthConstants.CHARACTER_UTF_8;


    /**
     * 默认响应格式方法
     * @param response 响应对象
     * @param object 写入的数据
     */
    public static void write(HttpServletResponse response, Object object)  {
       ResponseUtil.write(response, contentType, charset, object);
    }

    /**
     * 提供响应格式
     * @param response
     * @param contentType
     * @param object
     */
    public static void write(HttpServletResponse response, String contentType, Object object) {
        ResponseUtil.write(response, contentType, charset, object);
    }


    /**
     * 提供响应格式
     * @param response
     * @param contentType
     * @param charset
     * @param object
     */
    public static void write(HttpServletResponse response, String contentType, String charset, Object object)  {
        try {
            response.setContentType(contentType);
            response.setCharacterEncoding(charset);
            PrintWriter printWriter = response.getWriter();
            printWriter.print(object);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("服务器出现异常，稍后重试～");
        }
    }
}
