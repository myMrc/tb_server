package com.gx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.Users;
import com.gx.mapper.UsersMapper;
import com.gx.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mrc
 * @since 2023-03-09
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Override
    public Users login(String account) {
        return getOne(new QueryWrapper<Users>().eq("account", account));
    }

    @Override
    public R selectUser(String account) {
        return R.ok(getOne(new QueryWrapper<Users>().eq("account", account))).setCode(1).setMsg(null);
    }
}
