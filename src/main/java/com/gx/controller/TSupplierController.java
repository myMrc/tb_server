package com.gx.controller;


import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TSupplier;
import com.gx.entity.TUser;
import com.gx.service.ITSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2023-03-18
 */
@RestController
@RequestMapping("/sup")
public class TSupplierController {

    @Autowired
    ITSupplierService supplierService;

    @GetMapping
    public R selectSupplier(Principal principal){

        Integer userId = JSONUtil.toBean(principal.getName(), TUser.class).getUserId();

        return supplierService.selectSupplier(userId);
    }

    @PostMapping
    public R addSupplier(TSupplier supplier,Principal principal){

        if(StringUtils.isEmpty(supplier.getCompanyName()))return R.failed("请输入名称！");

        supplier.setUserId(JSONUtil.toBean(principal.getName(), TUser.class).getUserId());

        return supplierService.addSupplier(supplier);
    }

    @PutMapping
    public R updateSupplier(TSupplier supplier){

        if(StringUtils.isEmpty(supplier.getCompanyName()))return R.failed("请输入名称！");

        return supplierService.updateSupplier(supplier);
    }
}
