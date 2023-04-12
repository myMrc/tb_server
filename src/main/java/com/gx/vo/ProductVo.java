package com.gx.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gx.entity.TProduct;
import lombok.Data;

@Data
@TableName("t_product")
public class ProductVo extends TProduct {

    @TableField(exist = false)
    private String productLineName;

    @TableField(exist = false)
    private String scopes;

    public String getScopes() {
        return getScopeBegin() +" -- "+ getScopeEnd();
    }
}
