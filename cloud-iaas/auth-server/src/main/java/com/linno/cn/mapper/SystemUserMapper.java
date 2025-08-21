package com.linno.cn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linno.cn.domain.SystemUser;

import java.util.Set;

/**
* @author zhengcong
* @description 针对表【sys_user(系统用户)】的数据库操作Mapper
* @createDate 2025-08-20 14:05:39
* @Entity com.linno.cn.domain.SystemUser
*/
public interface SystemUserMapper extends BaseMapper<SystemUser> {
    /**
     * 根据用户的id查询用户权限列表
     */
    Set<String> getUserPermsById(Long userId);
}




