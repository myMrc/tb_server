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
 * @since 2023-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_join_apply")
public class TJoinApply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "join_apply_id", type = IdType.AUTO)
    private Integer joinApplyId;

    private Integer supplierId;

    private Integer resellerId;

    private Boolean joinApplyState;

    private LocalDate joinApplyDate;


}
