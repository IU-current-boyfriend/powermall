package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 多租户改造
 * @TableName his_config_info
 */
@TableName(value ="his_config_info")
@Data
public class HisConfigInfo implements Serializable {
    /**
     * 
     */
    @TableId(value = "nid", type = IdType.AUTO)
    private Long nid;

    /**
     * 
     */
    @TableField(value = "id")
    private Long id;

    /**
     * 
     */
    @TableField(value = "data_id")
    private String dataId;

    /**
     * 
     */
    @TableField(value = "group_id")
    private String groupId;

    /**
     * app_name
     */
    @TableField(value = "app_name")
    private String appName;

    /**
     * 
     */
    @TableField(value = "content")
    private String content;

    /**
     * 
     */
    @TableField(value = "md5")
    private String md5;

    /**
     * 
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 
     */
    @TableField(value = "src_user")
    private String srcUser;

    /**
     * 
     */
    @TableField(value = "src_ip")
    private String srcIp;

    /**
     * 
     */
    @TableField(value = "op_type")
    private String opType;

    /**
     * 租户字段
     */
    @TableField(value = "tenant_id")
    private String tenantId;

    /**
     * 秘钥
     */
    @TableField(value = "encrypted_data_key")
    private String encryptedDataKey;


    private static final long serialVersionUID = 1L;
}