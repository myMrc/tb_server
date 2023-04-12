package com.gx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.query.MPJQueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gx.mapper.TProductlineMapper;
import com.gx.service.ITProductlineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gx.vo.ProductLineVo;
import com.gx.vo.ProductVo;
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
public class TProductlineServiceImpl extends ServiceImpl<TProductlineMapper, ProductLineVo> implements ITProductlineService {

    @Override
    public R select(Integer userId, String seachTex,Integer current,Integer size) {

        Page<ProductLineVo> page = page(new Page<>(current, size), new MPJLambdaWrapper<ProductLineVo>()
                                  .selectAll(ProductLineVo.class)
                                  .selectCount(ProductVo::getProductId,ProductLineVo::getProductCount)
                                  .leftJoin(ProductVo.class, ProductVo::getProductLineId, ProductLineVo::getProductLineId)
                                  .eq(ProductLineVo::getUserId,userId)
                                  .like(ProductLineVo::getProductLineName, seachTex)
                                  .groupBy(ProductLineVo::getProductLineId)
                                  .orderByDesc(ProductLineVo::getProductLineId));

        return page == null ? R.failed("查询失败！") : R.ok(page).setCode(1).setMsg(null);
    }

    @Override
    public R selectById(Integer id) {

        ProductLineVo productline = getById(id);

        return productline == null ? R.failed("查询失败！") : R.ok(productline).setCode(1).setMsg(null);
    }

    @Override
    public R selectList(Integer userId) {

        List<ProductLineVo> list = list(new LambdaQueryWrapper<ProductLineVo>()
                                  .eq(ProductLineVo::getUserId,userId)
                                  .select(ProductLineVo::getProductLineName,ProductLineVo::getProductLineId)
                                  .orderByDesc(ProductLineVo::getProductLineId));

        return list == null ? R.failed("查询失败！") : R.ok(list).setCode(1).setMsg(null);
    }

    @Override
    public R insert(ProductLineVo productline) {

        int count = count(new LambdaQueryWrapper<ProductLineVo>()
                   .eq(ProductLineVo::getUserId, productline.getUserId())
                   .eq(ProductLineVo::getProductLineName, productline.getProductLineName()));

        if(count >0)return R.failed("产品线名称已存在！").setCode(0);

        boolean save = save(productline);

        return save ? R.ok(save).setCode(1).setMsg("保存成功") : R.failed("保存失败!");
    }

    @Override
    public R update(ProductLineVo productline) {

        int count = count(new LambdaQueryWrapper<ProductLineVo>()
                   .eq(ProductLineVo::getUserId, productline.getUserId())
                   .eq(ProductLineVo::getProductLineName, productline.getProductLineName())
                   .ne(ProductLineVo::getProductLineId,productline.getProductLineId()));

        if(count >0)return R.failed("产品线名称已存在！").setCode(0);

        boolean update = updateById(productline);

        return update ? R.ok(update).setCode(1).setMsg("保存成功") : R.failed("保存失败！");
    }

    @Override
    public R deleteById(Integer id) {

        int count = count(new MPJLambdaWrapper<ProductLineVo>()
                   .innerJoin(ProductVo.class, ProductVo::getProductLineId, ProductLineVo::getProductLineId)
                   .eq(ProductLineVo::getProductLineId, id));

        if(count > 0)return R.failed("产品数量大于0不能删除！").setCode(0);

        boolean remove = removeById(id);

        return remove ? R.ok(remove).setCode(1).setMsg("删除成功") : R.failed("删除失败！");
    }
}
