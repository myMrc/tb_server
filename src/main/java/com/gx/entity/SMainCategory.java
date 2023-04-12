package com.gx.entity;

import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("s_main_category")
public class SMainCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer categoryId;

    private Integer userId;


}
