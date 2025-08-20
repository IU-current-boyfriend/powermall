package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName app_connect
 */
@TableName(value ="app_connect")
@Data
public class AppConnect implements Serializable {
    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 本系统userId
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 第三方系统id 1：微信小程序
     */
    @TableField(value = "app_id")
    private Integer appId;

    /**
     * 第三方系统昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 第三方系统头像
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 第三方系统userid
     */
    @TableField(value = "biz_user_id")
    private String bizUserId;

    /**
     * 第三方系统unionid
     */
    @TableField(value = "biz_unionid")
    private String bizUnionid;


    private static final long serialVersionUID = 1L;
}