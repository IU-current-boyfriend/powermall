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
 * @TableName t_tx_exception
 */
@TableName(value ="t_tx_exception")
@Data
public class TTxException implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 
     */
    @TableField(value = "ex_state")
    private Integer exState;

    /**
     * 
     */
    @TableField(value = "group_id")
    private String groupId;

    /**
     * 
     */
    @TableField(value = "mod_id")
    private String modId;

    /**
     * 
     */
    @TableField(value = "registrar")
    private Integer registrar;

    /**
     * 
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 
     */
    @TableField(value = "transaction_state")
    private Integer transactionState;

    /**
     * 
     */
    @TableField(value = "unit_id")
    private String unitId;


    private static final long serialVersionUID = 1L;
}