package com.gx.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gx.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.transform.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mrc
 * @since 2023-03-09
 */
public interface IUsersService extends IService<Users> {

    Users login(String account);

    R selectUser(String account);
}
