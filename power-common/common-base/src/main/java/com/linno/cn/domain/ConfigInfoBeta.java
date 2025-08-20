package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * config_info_beta
 * @TableName config_info_beta
 */
@TableName(value ="config_info_beta")
@Data
public class ConfigInfoBeta implements Serializable {
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
     * group_id
     */
    @TableField(value = "group_id")
    private String groupId;

    /**
     * app_name
     */
    @TableField(value = "app_name")
    private String appName;

    /**
     * content
     */
    @TableField(value = "content")
    private String content;

    /**
     * betaIps
     */
    @TableField(value = "beta_ips")
    private String betaIps;

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