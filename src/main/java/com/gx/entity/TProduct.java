package com.gx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * @author 
 * @since 2023-03-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_product")
public class TProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

    private Integer productLineId;

    private Integer categoryId;

    private String productName;

    private Boolean productState;

    private Integer productPostage;

    private Integer productCount;

    private Integer productPrice;

    private Integer purchasePrice;

    private Integer scopeEnd;

    private Integer scopeBegin;

    private Integer downloadCount;

    private Integer purchaseCount;

    private LocalDate dateUpdated;


}
