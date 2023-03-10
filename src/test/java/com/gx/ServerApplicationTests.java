package com.gx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.Users;
import com.gx.mapper.UsersMapper;
import com.gx.service.IUsersService;
import org.apache.catalina.User;
import org.apache.catalina.Wrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.transform.Result;

@SpringBootTest
class ServerApplicationTests {

    @Autowired
    protected IUsersService usersService;

    @Test
    void contextLoads() {
        R login = usersService.login("admin", "123");
        System.out.println(login);

        R selectUser = usersService.selectUser(2);
        System.out.println(selectUser);
    }

}
