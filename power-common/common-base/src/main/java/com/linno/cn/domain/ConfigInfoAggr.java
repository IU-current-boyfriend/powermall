package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 增加租户字段
 * @TableName config_info_aggr
 */
@TableName(value ="config_info_aggr")
@Data
public class ConfigInfoAggr implements Serializable {
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
     * datum_id
     */
    @TableField(value = "datum_id")
    private String datumId;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

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

    private static final long serialVersionUID = 1L;
}