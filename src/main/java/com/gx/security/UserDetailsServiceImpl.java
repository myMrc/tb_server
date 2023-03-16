package com.gx.security;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.gx.entity.Users;
import com.gx.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Users users = usersService.login(username);
        if(users == null){
            throw new UsernameNotFoundException("账号或密码错误");
        }
        return new UserLogin(users.getUsersID(),users.getAccount(),users.getPassword(),getUserAuthority(users.getUsersID()));
    }
    //获取权限信息
    public List<GrantedAuthority> getUserAuthority(Integer userId){
        return null;
    }
}
