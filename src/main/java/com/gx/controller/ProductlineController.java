package com.gx.controller;


import com.baomidou.mybatisplus.extension.api.R;
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
@RequestMapping("/supProLine")
public class ProductlineController {

    @Autowired
    IProductlineService supProLineService;

    @GetMapping
    public R selectSupProLine(Principal principal){
        return supProLineService.selectSupProLine(Integer.parseInt(principal.getName()));
    }
}
