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
@TableName("accredit")
public class Accredit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "AccreditID", type = IdType.AUTO)
    private Integer AccreditID;

    private Integer ProductID;

    private Integer UsersID;


}