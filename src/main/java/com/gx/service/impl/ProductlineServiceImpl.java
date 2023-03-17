package com.gx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.Productline;
import com.gx.entity.Users;
import com.gx.mapper.ProductlineMapper;
import com.gx.service.IProductlineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mrc
 * @since 2023-03-09
 */
@Service
public class ProductlineServiceImpl extends ServiceImpl<ProductlineMapper, Productline> implements IProductlineService {

    @Override
    public R selectSupProLine(int userId) {
        List<Productline> list = list(new LambdaQueryWrapper<Productline>().eq(Productline::getUsersID, userId));
        return list == null? R.failed("查询失败") : R.ok(list).setCode(1).setMsg(null);
    }
}
