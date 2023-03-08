package com.gx.controller;


import com.gx.common.Code;
import com.gx.common.Msg;
import com.gx.common.Result;
import com.gx.entity.Users;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2023-03-06
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @PostMapping("/login")
    public Result login(Users users){
        System.out.println(users);
        return new  Result(Code.SELECT_OK,users, Msg.SELECT_OK);
    }
}
