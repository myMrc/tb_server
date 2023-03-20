package com.gx.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TUser;
import com.gx.service.ITUserService;
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
@RequestMapping("/user")
public class TUserController {

    @Autowired
    ITUserService userService;

    @PostMapping("/login")
    public R loginUser(TUser user){
        if(StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getUserCode().trim())) return R.failed("请输入账号和密码");

        return userService.loginUser(user);
    }

    @PostMapping("/register")
    public R addUser(TUser user){

        if(StringUtils.isEmpty(user.getUserName().trim()) || StringUtils.isEmpty(user.getUserCode().trim())) return R.failed("请输入账号和密码");

        return userService.addUser(user);
    }

    @PutMapping("/{reloId}")
    public R updataUser(Principal principal, @PathVariable int reloId){

        Integer userId = JSONUtil.toBean(principal.getName(), TUser.class).getUserId();

        return userService.updateUser(new TUser().setUserId(userId).setReloId(reloId));
    }

    @GetMapping
    public R selectUser(Principal principal){

        Integer userId = JSONUtil.toBean(principal.getName(), TUser.class).getUserId();

        return userService.selectUser(userId);
    }

    @DeleteMapping
    public R deleteUser(Principal principal){

        Integer userId = JSONUtil.toBean(principal.getName(), TUser.class).getUserId();

        return userService.deleteUser(userId);
    }

}
