package com.gx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2023-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("productline")
public class Productline implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ProductLineID", type = IdType.AUTO)
    private Integer ProductLineID;

    private Integer UsersID;

    private Integer PurchasePrice;

    private Integer ScopeEnd;

    private Integer ScopeBegin;

    private String ProductLineName;


}
