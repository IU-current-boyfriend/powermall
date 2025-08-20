package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * config_info_tag
 * @TableName config_info_tag
 */
@TableName(value ="config_info_tag")
@Data
public class ConfigInfoTag implements Serializable {
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
     * tenant_id
     */
    @TableField(value = "tenant_id")
    private String tenantId;

    /**
     * tag_id
     */
    @TableField(value = "tag_id")
    private String tagId;

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


    private static final long serialVersionUID = 1L;
}