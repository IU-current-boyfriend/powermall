package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 购物车
 * @TableName basket
 */
@TableName(value ="basket")
@Data
public class Basket implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "basket_id", type = IdType.AUTO)
    private Long basketId;

    /**
     * 店铺ID
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 产品ID
     */
    @TableField(value = "prod_id")
    private Long prodId;

    /**
     * SkuID
     */
    @TableField(value = "sku_id")
    private Long skuId;

    /**
     * 用户ID
     */
    @TableField(value = "open_id")
    private String openId;

    /**
     * 购物车产品个数
     */
    @TableField(value = "prod_count")
    private Integer prodCount;

    /**
     * 购物时间
     */
    @TableField(value = "create_time")
    private Date createTime;


    private static final long serialVersionUID = 1L;
}