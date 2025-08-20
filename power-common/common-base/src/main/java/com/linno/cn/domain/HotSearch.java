package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 热搜
 * @TableName hot_search
 */
@TableName(value ="hot_search")
@Data
public class HotSearch implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "hot_search_id", type = IdType.AUTO)
    private Long hotSearchId;

    /**
     * 店铺ID 0为全局热搜
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 录入时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 顺序
     */
    @TableField(value = "seq")
    private Integer seq;

    /**
     * 状态 0下线 1上线
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 热搜标题
     */
    @TableField(value = "title")
    private String title;


    private static final long serialVersionUID = 1L;
}