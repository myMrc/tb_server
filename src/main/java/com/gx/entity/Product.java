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
 * @author mrc
 * @since 2023-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ProductID", type = IdType.AUTO)
    private Integer ProductID;

    private Integer ProductLineID;

    private String ProductTitle;

    private String ProductClass;

    private Boolean ProductStatus;

    private Boolean ProductPostage;

    private Integer ProductInventory;

    private Integer ProductPrice;

    private Integer PurchasePrice;

    private Integer ScopeEnd;

    private Integer ScopeBegin;


}
