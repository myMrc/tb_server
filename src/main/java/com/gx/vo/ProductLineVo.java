package com.gx.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gx.entity.TProductline;
import lombok.Data;

@Data
@TableName("t_productline")
public class ProductLineVo extends TProductline {

    @TableField(exist = false)
    private Integer productCount;

    @TableField(exist = false)
    private String scopes;

    @TableField(exist = false)
    private String purPrice;

    public String getScopes() {
        return "标准价 "+getScopeBegin() +"% -- 标准价 "+ getScopeEnd() +"%";
    }

    public String getPurPrice() {
        return "标准价 "+ getScopeEnd() +"%";
    }
}
