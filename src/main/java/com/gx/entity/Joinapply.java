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
 * @author author
 * @since 2023-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("joinapply")
public class Joinapply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "JoinApply", type = IdType.AUTO)
    private Integer JoinApply;

    private Integer DistributorID;

    private Integer SupplierID;

    private Boolean ApplyState;

    private LocalDate ApplyDate;


}
