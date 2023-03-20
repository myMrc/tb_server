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
@TableName("t_join_hands")
public class TJoinHands implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "join_hands_id", type = IdType.AUTO)
    private Integer joinHandsId;

    private Integer supplierId;

    private Integer resellerId;

    private LocalDate joinHandsEnd;

    private LocalDate joinHandsBegin;

    private Boolean joinHandsState;

    private String joinHandsMemo;


}
