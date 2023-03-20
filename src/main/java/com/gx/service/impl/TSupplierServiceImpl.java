package com.gx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TSupplier;
import com.gx.mapper.TSupplierMapper;
import com.gx.service.ITSupplierService;
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
public class TSupplierServiceImpl extends ServiceImpl<TSupplierMapper, TSupplier> implements ITSupplierService {

    @Override
    public R addSupplier(TSupplier supplier) {

        TSupplier one = getOne(new LambdaQueryWrapper<TSupplier>().eq(TSupplier::getUserId, supplier.getUserId()));

        if(one != null)return R.failed("sup已存在");

        boolean save = save(supplier);

        return save ? R.ok(save).setCode(1).setMsg("保存成功") : R.failed("保存失败");
    }
}
