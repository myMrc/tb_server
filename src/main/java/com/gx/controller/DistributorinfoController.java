package com.gx.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.Distributorinfo;
import com.gx.service.IDistributorinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/dis")
public class DistributorinfoController {

    @Autowired
    IDistributorinfoService disService;

    @GetMapping
    public R seletDis(Principal principal){
        return disService.selectDis(Integer.parseInt(principal.getName()));
    }

    @PutMapping
    public R updateDis(Distributorinfo dis){
        return disService.updateDis(dis);
    }
}
