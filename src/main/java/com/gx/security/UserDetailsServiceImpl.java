//package com.gx.security;
//
//import com.gx.entity.TUser;
//import com.gx.service.ITUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    ITUserService usersService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        TUser user = usersService.loginUser(username);
//        if(user == null){
//            throw new UsernameNotFoundException("账号或密码错误");
//        }
//        return new UserLogin(user.getUserId(),user.getUserName(),user.getUserCode(),getUserAuthority(user.getUserId()));
//    }
//    //获取权限信息
//    public List<GrantedAuthority> getUserAuthority(Integer userId){
//        return null;
//    }
//}
