package com.gx.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-03-18
 */
public interface ITUserService extends IService<TUser> {

    R loginUser(TUser user);

    R addUser(TUser user);

    R updateUser(TUser user);

    R selectUser(Integer userId);

    R deleteUser(Integer userId);
}
