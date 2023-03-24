package com.gx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TProductline;
import com.gx.mapper.TProductlineMapper;
import com.gx.service.ITProductlineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2023-03-18
 */
@Service
public class TProductlineServiceImpl extends ServiceImpl<TProductlineMapper, TProductline> implements ITProductlineService {

    @Autowired
    TProductlineMapper productlineMapper;

    @Override
    public R selectProductline(Integer userId, String seachTex) {

        List<TProductline> list = productlineMapper.listProductline(userId, seachTex);

        return list == null ? R.failed("查询失败！") : R.ok(list).setCode(1).setMsg("查询成功");
    }

    @Override
    public R addProductline(Integer userId, TProductline productline) {

        int count = productlineMapper.oneProductline(userId, productline.getProductLineName());

        if(count >0)return R.failed("产品线名称已存在！");

        return null;
    }

    @Override
    public R updateProductline(TProductline productline) {

        boolean update = updateById(productline);

        return update ? R.ok(update).setCode(1).setMsg("更新成功") : R.failed("更新失败！");
    }
}
