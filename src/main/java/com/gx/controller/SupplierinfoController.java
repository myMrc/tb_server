package com.gx.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.gx.security.UserLogin;
import com.gx.service.ISupplierinfoService;
import com.gx.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
@RequestMapping("/sup")
public class SupplierinfoController {

    @Autowired
    ISupplierinfoService supService;

    @GetMapping
    public R selectSup(Principal principal){
        return supService.selectSup(Integer.parseInt(principal.getName()));
    }
}
