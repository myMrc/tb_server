package com.gx.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.gx.service.IProductService;
import com.gx.service.IProductlineService;
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
 * @author mrc
 * @since 2023-03-09
 */
@RestController
@RequestMapping("/supPro")
public class ProductController {

    @Autowired
    IProductService supProService;

    @GetMapping
    public R selectSupPro(Principal principal){
        return supProService.selectSupPro(Integer.parseInt(principal.getName()));
    }
}
