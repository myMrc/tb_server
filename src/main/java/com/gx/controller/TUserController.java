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
    public R login(@RequestBody TUser user){

        if(StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getUserCode().trim()))

        return R.failed("请输入账号和密码").setCode(0);

        return userService.login(user);
    }

    @PostMapping
    public R insert(@RequestBody TUser user){

        if(StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getUserCode()))

        return R.failed("请输入账号和密码").setCode(0);

        return userService.insert(user);
    }

    @PutMapping("/{roleId}")
    public R update(Principal principal, @PathVariable int roleId){

        Integer userId = Integer.parseInt(principal.getName());

        return userService.update(new TUser().setUserId(userId).setRoleId(roleId));
    }

    @GetMapping
    public R selectById(Principal principal){

        Integer userId = Integer.parseInt(principal.getName());

        return userService.selectById(userId);
    }

    @DeleteMapping
    public R deleteById(Principal principal){

        Integer userId = Integer.parseInt(principal.getName());

        return userService.deleteById(userId);
    }

}
