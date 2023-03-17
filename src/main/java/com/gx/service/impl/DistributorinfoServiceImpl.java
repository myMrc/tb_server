package com.gx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.Distributorinfo;
import com.gx.entity.Supplierinfo;
import com.gx.mapper.DistributorinfoMapper;
import com.gx.service.IDistributorinfoService;
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
public class DistributorinfoServiceImpl extends ServiceImpl<DistributorinfoMapper, Distributorinfo> implements IDistributorinfoService {

    @Override
    public R selectDis(int userId) {
        Distributorinfo dis = getOne(new LambdaQueryWrapper<Distributorinfo>().eq(Distributorinfo::getUsersID, userId));
        return dis == null? R.failed("查询失败！") : R.ok(dis).setCode(1).setMsg(null);
    }

    @Override
    public R updateDis(Distributorinfo dis) {
        boolean ds = updateById(dis);
        return ds == true? R.failed("修改成功").setCode(1) : R.failed("修改失败");
    }
}
