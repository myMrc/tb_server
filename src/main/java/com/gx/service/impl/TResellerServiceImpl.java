package com.gx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TReseller;
import com.gx.entity.TSupplier;
import com.gx.mapper.TResellerMapper;
import com.gx.service.ITResellerService;
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
public class TResellerServiceImpl extends ServiceImpl<TResellerMapper, TReseller> implements ITResellerService {

    @Override
    public R addReseller(TReseller reseller) {

        TReseller one = getOne(new LambdaQueryWrapper<TReseller>().eq(TReseller::getUserId, reseller.getUserId()));

        if(one != null)return R.failed("res已存在");

        boolean save = save(reseller);

        return save ? R.ok(save).setCode(1).setMsg("保存成功") : R.failed("保存失败!");
    }
}
