package com.gx.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.gx.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/user")
public class UsersController {

    @Autowired
    IUsersService usersService;

    @GetMapping
    public R selectUser(Principal principal){
        return usersService.selectUser(Integer.parseInt(principal.getName()));
    }
}
