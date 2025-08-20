package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * config_tag_relation
 * @TableName config_tags_relation
 */
@TableName(value ="config_tags_relation")
@Data
public class ConfigTagsRelation implements Serializable {
    /**
     * 
     */
    @TableId(value = "nid", type = IdType.AUTO)
    private Long nid;

    /**
     * id
     */
    @TableField(value = "id")
    private Long id;

    /**
     * tag_name
     */
    @TableField(value = "tag_name")
    private String tagName;

    /**
     * tag_type
     */
    @TableField(value = "tag_type")
    private String tagType;

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


    private static final long serialVersionUID = 1L;
}