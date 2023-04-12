package com.gx.controller;


import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TReseller;
import com.gx.entity.TSupplier;
import com.gx.entity.TUser;
import com.gx.service.ITResellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/res")
public class TResellerController {

    @Autowired
    ITResellerService resellerService;

    @PostMapping
    public R addReseller(TReseller reseller, Principal principal){

        if(StringUtils.isEmpty(reseller.getCompanyName()))return R.failed("请输入名称！");

        reseller.setUserId(JSONUtil.toBean(principal.getName(), TUser.class).getUserId());

        return resellerService.addReseller(reseller);
    }
}
