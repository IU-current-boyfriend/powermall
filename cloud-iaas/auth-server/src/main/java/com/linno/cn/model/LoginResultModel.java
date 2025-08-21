package com.linno.cn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

/**
 * 登录结果集模型对象
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResultModel {
    // 用户凭证信息
    private String accessToken;
    // 用户权限列表信息
    private Set<String> permissions;
}
