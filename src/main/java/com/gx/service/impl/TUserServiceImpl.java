package com.gx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TUser;
import com.gx.mapper.TUserMapper;
import com.gx.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gx.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author
 * @since 2023-03-18
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public R login(TUser user) {

        TUser one = getOne(new LambdaQueryWrapper<TUser>()
                    .eq(TUser::getUserName, user.getUserName())
                    .eq(TUser::getUserCode, user.getUserCode()));

        return one == null? R.failed("密码错误！") : R.ok(jwtUtil.setToken(one.getUserId())).setCode(1).setMsg("登录成功");
    }

    @Override
    public R insert(TUser user) {

        TUser one = getOne(new LambdaQueryWrapper<TUser>().eq(TUser::getUserName, user.getUserName()));

        if (one != null)return R.failed("用户名已存在！");

        boolean save = save(user.setRoleId(3));

        return save ? R.ok(save).setCode(1).setMsg("注册成功") : R.failed("注册失败!");
    }

    @Override
    public R update(TUser user) {

        boolean update = updateById(user);

        return update ? R.ok(update).setCode(1).setMsg("更新成功") : R.failed("更新失败!");
    }

    @Override
    public R selectById(Integer userId) {

        TUser user = getById(userId);

        return user == null? R.failed("查询失败！") : R.ok(user).setCode(1).setMsg(null);
    }

    @Override
    public R deleteById(Integer userId) {

        boolean remove = removeById(userId);

        return remove ? R.ok(remove).setCode(1).setMsg("注销成功") : R.failed("注销失败!");
    }
}
