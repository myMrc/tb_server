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
@TableName("t_reseller")
public class TReseller implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "reseller_id", type = IdType.AUTO)
    private Integer resellerId;

    private Integer userId;

    private String resellerName;

    private String companyName;

    private String companyInfo;

    private String companyUrl;

    private LocalDate startDate;

    private String phone;

    private String email;

    private String wang;


}
