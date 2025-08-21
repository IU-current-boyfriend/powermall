package com.linno.cn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhengcong
 * @Desc: 用于统一多端系统Security认证用户信息的模型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserModel implements UserDetails {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户密码
     *
     */
    private String password;

    /**
     * 用户状态
     *
     */
    private Integer status;

    /**
     * 商城id
     *
     */
    private Long shopId;

    /**
     * 系统类型
     */
    private String loginType;

    /**
     * 用户权限集合
     */
    private Set<String> perms = new HashSet<>();


    /**
     * 处理perms权限列表的格式
     */
    public void setPerms(Set<String> permissionList, String separator) {
        permissionList.forEach(permission -> {
            // 判断该字符串中是否包含","分隔符
            boolean existMark = permission.contains(separator);
            if (!existMark) {
                // 不包含,分隔符,说明当前只存在单个权限
                this.perms.add(permission);
            } else {
                // 如果包含分隔符,说明存在多个权限
                String[] permsList = permission.split(separator);
                this.perms.addAll(Arrays.asList(permsList));
            }
        });
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perms.stream().map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.loginType + this.userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.status == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.status == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.status == 1;
    }

    @Override
    public boolean isEnabled() {
        return this.status == 1;
    }
}
