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
 * @TableName transport
 */
@TableName(value ="transport")
@Data
public class Transport implements Serializable {
    /**
     * 运费模板id
     */
    @TableId(value = "transport_id", type = IdType.AUTO)
    private Long transportId;

    /**
     * 运费模板名称
     */
    @TableField(value = "trans_name")
    private String transName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 店铺id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 收费方式（0 按件数,1 按重量 2 按体积）
     */
    @TableField(value = "charge_type")
    private Integer chargeType;

    /**
     * 是否包邮 0:不包邮 1:包邮
     */
    @TableField(value = "is_free_fee")
    private Integer isFreeFee;

    /**
     * 是否含有包邮条件 0 否 1是
     */
    @TableField(value = "has_free_condition")
    private Integer hasFreeCondition;


    private static final long serialVersionUID = 1L;
}