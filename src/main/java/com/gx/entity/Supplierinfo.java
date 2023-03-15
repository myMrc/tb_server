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
@TableName("supplierinfo")
public class Supplierinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "SupplierInfoID", type = IdType.AUTO)
    private Integer SupplierInfoID;

    private Integer UsersID;

    private String CompanyName;

    private String CompanyInfo;

    private String Contacts;

    private String Phone;

    private String Email;

    private String Wang;

    private String MainClass;

    private String MainBrand;

    private String RecruitmentName;

    private String RecruitmentLetter;

    private Boolean RecruitmentStatus;


}
