package com.gx.controller;


import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TUser;
import com.gx.service.ITProductlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/supProLine")
public class TProductlineController {

    @Autowired
    ITProductlineService productlineService;

    @GetMapping
    public R selectProductline(Principal principal){

        Integer userId = JSONUtil.toBean(principal.getName(), TUser.class).getUserId();

        return productlineService.selectProductline(userId);
    }
}
