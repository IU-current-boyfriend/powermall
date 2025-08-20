package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName hibernate_sequence
 */
@TableName(value ="hibernate_sequence")
@Data
public class HibernateSequence implements Serializable {
    /**
     * 
     */
    @TableField(value = "next_val")
    private Long nextVal;


    private static final long serialVersionUID = 1L;
}