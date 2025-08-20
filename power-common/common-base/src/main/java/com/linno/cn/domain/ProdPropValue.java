package com.linno.cn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName prod_prop_value
 */
@TableName(value ="prod_prop_value")
@Data
public class ProdPropValue implements Serializable {
    /**
     * 属性值ID
     */
    @TableId(value = "value_id", type = IdType.AUTO)
    private Long valueId;

    /**
     * 属性值名称
     */
    @TableField(value = "prop_value")
    private String propValue;

    /**
     * 属性ID
     */
    @TableField(value = "prop_id")
    private Long propId;


    private static final long serialVersionUID = 1L;
}