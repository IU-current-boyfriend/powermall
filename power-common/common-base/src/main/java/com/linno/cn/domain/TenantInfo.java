package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * tenant_info
 * @TableName tenant_info
 */
@TableName(value ="tenant_info")
@Data
public class TenantInfo implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * kp
     */
    @TableField(value = "kp")
    private String kp;

    /**
     * tenant_id
     */
    @TableField(value = "tenant_id")
    private String tenantId;

    /**
     * tenant_name
     */
    @TableField(value = "tenant_name")
    private String tenantName;

    /**
     * tenant_desc
     */
    @TableField(value = "tenant_desc")
    private String tenantDesc;

    /**
     * create_source
     */
    @TableField(value = "create_source")
    private String createSource;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Long gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    private Long gmtModified;


    private static final long serialVersionUID = 1L;
}