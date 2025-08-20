package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * config_info
 * @TableName config_info
 */
@TableName(value ="config_info")
@Data
public class ConfigInfo implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * data_id
     */
    @TableField(value = "data_id")
    private String dataId;

    /**
     * 
     */
    @TableField(value = "group_id")
    private String groupId;

    /**
     * content
     */
    @TableField(value = "content")
    private String content;

    /**
     * md5
     */
    @TableField(value = "md5")
    private String md5;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * source user
     */
    @TableField(value = "src_user")
    private String srcUser;

    /**
     * source ip
     */
    @TableField(value = "src_ip")
    private String srcIp;

    /**
     * 
     */
    @TableField(value = "app_name")
    private String appName;

    /**
     * 租户字段
     */
    @TableField(value = "tenant_id")
    private String tenantId;

    /**
     * 
     */
    @TableField(value = "c_desc")
    private String cDesc;

    /**
     * 
     */
    @TableField(value = "c_use")
    private String cUse;

    /**
     * 
     */
    @TableField(value = "effect")
    private String effect;

    /**
     * 
     */
    @TableField(value = "type")
    private String type;

    /**
     * 
     */
    @TableField(value = "c_schema")
    private String cSchema;

    /**
     * 秘钥
     */
    @TableField(value = "encrypted_data_key")
    private String encryptedDataKey;

    ''
    private static final long serialVersionUID = 1L;
}