package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName permissions
 */
@TableName(value ="permissions")
@Data
public class Permissions implements Serializable {
    /**
     * 
     */
    @TableField(value = "role")
    private String role;

    /**
     * 
     */
    @TableField(value = "resource")
    private String resource;

    /**
     * 
     */
    @TableField(value = "action")
    private String action;


    private static final long serialVersionUID = 1L;
}