package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 主页轮播图
 * @TableName index_img
 */
@TableName(value ="index_img")
@Data
public class IndexImg implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "img_id", type = IdType.AUTO)
    private Long imgId;

    /**
     * 店铺ID
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 图片
     */
    @TableField(value = "img_url")
    private String imgUrl;

    /**
     * 说明文字,描述
     */
    @TableField(value = "des")
    private String des;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 链接
     */
    @TableField(value = "link")
    private String link;

    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 顺序
     */
    @TableField(value = "seq")
    private Integer seq;

    /**
     * 上传时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 关联
     */
    @TableField(value = "prod_id")
    private Long prodId;

    /**
     * 关联商品类型，0已关联商品,-1未关联商品
     */
    @TableField(value = "type")
    private Integer type;


    private static final long serialVersionUID = 1L;
}