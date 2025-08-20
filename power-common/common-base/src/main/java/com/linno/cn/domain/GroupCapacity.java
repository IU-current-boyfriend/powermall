package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 集群、各Group容量信息表
 * @TableName group_capacity
 */
@TableName(value ="group_capacity")
@Data
public class GroupCapacity implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * Group ID，空字符表示整个集群
     */
    @TableField(value = "group_id")
    private String groupId;

    /**
     * 配额，0表示使用默认值
     */
    @TableField(value = "quota")
    private Integer quota;

    /**
     * 使用量
     */
    @TableField(value = "usage")
    private Integer usage;

    /**
     * 单个配置大小上限，单位为字节，0表示使用默认值
     */
    @TableField(value = "max_size")
    private Integer maxSize;

    /**
     * 聚合子配置最大个数，，0表示使用默认值
     */
    @TableField(value = "max_aggr_count")
    private Integer maxAggrCount;

    /**
     * 单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值
     */
    @TableField(value = "max_aggr_size")
    private Integer maxAggrSize;

    /**
     * 最大变更历史数量
     */
    @TableField(value = "max_history_count")
    private Integer maxHistoryCount;

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


    private static final long serialVersionUID = 1L;
}