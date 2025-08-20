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
 * @TableName member_collection
 */
@TableName(value ="member_collection")
@Data
public class MemberCollection implements Serializable {
    /**
     * 收藏表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    @TableField(value = "prod_id")
    private Long prodId;

    /**
     * 用户id
     */
    @TableField(value = "open_id")
    private String openId;

    /**
     * 收藏时间
     */
    @TableField(value = "create_time")
    private Date createTime;


    private static final long serialVersionUID = 1L;
}