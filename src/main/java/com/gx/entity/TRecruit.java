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
 * @author 
 * @since 2023-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_recruit")
public class TRecruit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "recruit_id", type = IdType.AUTO)
    private Integer recruitId;

    private Integer supplierId;

    private String recruitName;

    private String recruitContent;

    private Boolean recruitState;


}
