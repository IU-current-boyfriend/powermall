package com.linno.cn.strategy;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.linno.cn.contants.AuthConstants;
import com.linno.cn.domain.SystemUser;
import com.linno.cn.mapper.SystemUserMapper;
import com.linno.cn.model.LoginUserModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Author: zhengcong
 * @Desc: 动力后台管理系统用户登录策略类
 */
@Component(AuthConstants.SYSTEM_POWER_BOSS)
public class PowerBossUserLoginStrategy implements LoginStrategy {


    @Resource
    private SystemUserMapper systemUserMapper;


    @Override
    public UserDetails realLogin(String loginAct) {
        /**
         * 后台管理系统用户登录策略类的流程：
         * 1. 根据用户登录名查询该用户是否存在数据库中
         * 2. 查询该用户的权限
         * 3. 返回统一的security需要的对象
         */

        //  SystemUser user = systemUserMapper.selectOne(new QueryWrapper<SystemUser>().eq("user_name", loginAct));

        SystemUser loginUser = systemUserMapper.selectOne(new LambdaUpdateWrapper<SystemUser>().eq(SystemUser::getUsername, loginAct));

        if (ObjectUtil.isNotNull(loginUser)) {
            // 查询用户的权限
            Set<String> perms = systemUserMapper.getUserPermsById(loginUser.getUserId());
            // 创建securityModel对象
            LoginUserModel loginUserModel = new LoginUserModel();
            // 设置securityModel对象信息
            loginUserModel.setUserId(loginUser.getUserId());
            loginUserModel.setUsername(loginUser.getUsername());
            loginUserModel.setPassword(loginUser.getPassword());
            loginUserModel.setStatus(loginUser.getStatus());
            loginUserModel.setShopId(loginUser.getShopId());
            loginUserModel.setLoginType(AuthConstants.SYSTEM_POWER_BOSS);
            // 该用户的权限列表不为空，设置该用户的权限列表
            if (ObjectUtil.isNotNull(perms) && !perms.isEmpty()) {
                loginUserModel.setPerms(perms, ",");
            }
            return loginUserModel;
        }
        return null;
    }
}
