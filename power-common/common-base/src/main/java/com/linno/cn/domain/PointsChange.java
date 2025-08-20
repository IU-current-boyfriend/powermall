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
 * @TableName points_change
 */
@TableName(value ="points_change")
@Data
public class PointsChange implements Serializable {
    /**
     * 积分流动记录表
     */
    @TableId(value = "points_change_id", type = IdType.AUTO)
    private Long pointsChangeId;

    /**
     * 积分钱包id
     */
    @TableField(value = "points_wallet_id")
    private Long pointsWalletId;

    /**
     * 增加或减少(增加 0 减少 1)
     */
    @TableField(value = "add_or_reduce")
    private Integer addOrReduce;

    /**
     * 原因(订单，邀请，签到，兑换)
     */
    @TableField(value = "reason")
    private Integer reason;

    /**
     * 积分状态（0:用户未收货待结算，1:已结算 2:用户退货退单）
     */
    @TableField(value = "state")
    private Integer state;

    /**
     * 积分数额
     */
    @TableField(value = "points_number")
    private Double pointsNumber;

    /**
     * 关联订单id
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * 商户订单id
     */
    @TableField(value = "merchant_order_id")
    private Long merchantOrderId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;


    private static final long serialVersionUID = 1L;
}