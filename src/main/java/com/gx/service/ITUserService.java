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

    R login(TUser user);

    R insert(TUser user);

    R update(TUser user);

    R selectById(Integer userId);

    R deleteById(Integer userId);
}
