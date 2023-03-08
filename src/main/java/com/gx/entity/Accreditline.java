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
@TableName("accreditline")
public class Accreditline implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "AccreditLineID", type = IdType.AUTO)
    private Integer AccreditLineID;

    private Integer ProductLineID;

    private Integer UsersID;


}
