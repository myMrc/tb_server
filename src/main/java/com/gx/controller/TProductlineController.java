package com.gx.controller;


import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TProductline;
import com.gx.entity.TUser;
import com.gx.service.ITProductlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/supProLine")
public class TProductlineController {

    @Autowired
    ITProductlineService productlineService;

    @GetMapping
    public R selectProductline(Principal principal, String seachTex){

        Integer userId = JSONUtil.toBean(principal.getName(), TUser.class).getUserId();

        return productlineService.selectProductline(userId,'%'+seachTex+'%');
    }

    @PostMapping
    public R addProductline(Principal principal, TProductline productline){

        if(StringUtils.isEmpty(productline.getProductLineName()))return R.failed("请输入产品线名称！");

        Integer userId = JSONUtil.toBean(principal.getName(), TUser.class).getUserId();

        return productlineService.addProductline(userId,productline);
    }

    @PutMapping
    public R updateProductline(TProductline productline){

        if(StringUtils.isEmpty(productline.getProductLineName()))return R.failed("请输入产品线名称！");

        return productlineService.updateProductline(productline);
    }
}
