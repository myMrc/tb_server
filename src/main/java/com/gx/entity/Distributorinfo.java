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
 * @author mrc
 * @since 2023-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("distributorinfo")
public class Distributorinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DistributorInfoID", type = IdType.AUTO)
    private Integer DistributorInfoID;

    private Integer UsersID;

    private LocalDate OpeningDate;

    private String DistributorName;

    private String Contacts;

    private String Phone;

    private String Email;

    private String Wang;


}
