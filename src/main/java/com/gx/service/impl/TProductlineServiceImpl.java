package com.gx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TProductline;
import com.gx.mapper.TProductlineMapper;
import com.gx.service.ITProductlineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TProductlineServiceImpl extends ServiceImpl<TProductlineMapper, TProductline> implements ITProductlineService {

    @Override
    public R selectProductline(Integer userId) {

        return null;
        //list(new LambdaQueryWrapper<TProductline>())
    }
}
