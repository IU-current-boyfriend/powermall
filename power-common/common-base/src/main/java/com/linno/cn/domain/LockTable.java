package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName lock_table
 */
@TableName(value ="lock_table")
@Data
public class LockTable implements Serializable {
    /**
     * 行键
     */
    @TableId(value = "row_key")
    private String rowKey;

    /**
     * 全局事务ID
     */
    @TableField(value = "xid")
    private String xid;

    /**
     * 全局事务ID，不带TC 地址
     */
    @TableField(value = "transaction_id")
    private Long transactionId;

    /**
     * 分支ID
     */
    @TableField(value = "branch_id")
    private Long branchId;

    /**
     * 资源ID
     */
    @TableField(value = "resource_id")
    private String resourceId;

    /**
     * 表名
     */
    @TableField(value = "table_name")
    private String tableName;

    /**
     * 主键对应的值
     */
    @TableField(value = "pk")
    private String pk;

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