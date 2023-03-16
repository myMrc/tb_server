package com.gx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.Supplierinfo;
import com.gx.mapper.SupplierinfoMapper;
import com.gx.service.ISupplierinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SupplierinfoServiceImpl extends ServiceImpl<SupplierinfoMapper, Supplierinfo> implements ISupplierinfoService {

    @Override
    public R selectSup(Integer userId) {
        Supplierinfo one = getOne(new LambdaQueryWrapper<Supplierinfo>().eq(Supplierinfo::getUsersID, userId));
        return one == null? R.failed("查询失败！") : R.ok(one).setCode(1).setMsg(null);
    }
}
