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
 * @TableName undo_log
 */
@TableName(value ="undo_log")
@Data
public class UndoLog implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    @TableField(value = "branch_id")
    private Long branchId;

    /**
     * 
     */
    @TableField(value = "xid")
    private String xid;

    /**
     * 
     */
    @TableField(value = "context")
    private String context;

    /**
     * 
     */
    @TableField(value = "log_status")
    private Integer logStatus;

    /**
     * 
     */
    @TableField(value = "log_created")
    private Date logCreated;

    /**
     * 
     */
    @TableField(value = "log_modified")
    private Date logModified;

    /**
     * 
     */
    @TableField(value = "ext")
    private String ext;

    /**
     * 
     */
    @TableField(value = "rollback_info")
    private byte[] rollbackInfo;


    private static final long serialVersionUID = 1L;
}