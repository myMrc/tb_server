package com.gx;

import com.gx.entity.Users;
import com.gx.mapper.UsersMapper;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {

    @Autowired
    protected UsersMapper usersMapper;

    @Test
    void contextLoads() {
        Users user = new Users();
        user.setAccount("123");
        user.setPassword("321");
        //usersMapper.selectOne(user);
    }

}
