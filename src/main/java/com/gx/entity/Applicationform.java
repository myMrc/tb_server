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
@TableName("applicationform")
public class Applicationform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ApplicationForm", type = IdType.AUTO)
    private Integer ApplicationForm;

    private Integer DistributorID;

    private Integer SupplierID;

    private LocalDate CoopEnd;

    private LocalDate CoopBegin;

    private Boolean CoopState;

    private String CoopMemo;


}
