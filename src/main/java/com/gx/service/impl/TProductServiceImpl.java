package com.gx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.query.MPJLambdaQueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gx.entity.TProduct;
import com.gx.entity.TProductline;
import com.gx.entity.TUser;
import com.gx.mapper.TProductMapper;
import com.gx.service.ITProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gx.vo.ProductLineVo;
import com.gx.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2023-03-24
 */
@Service
public class TProductServiceImpl extends ServiceImpl<TProductMapper, ProductVo> implements ITProductService {

    @Override
    public R select(Integer userId, String seachTex, Integer current, Integer size) {

        Page<ProductVo> page = page(new Page<>(current, size), new MPJLambdaWrapper<ProductVo>()
                              .selectAll(ProductVo.class)
                              .select(ProductLineVo::getProductLineName)
                              .leftJoin(ProductLineVo.class, ProductLineVo::getProductLineId, ProductLineVo::getProductLineId)
                              .leftJoin(TUser.class, TUser::getUserId, ProductLineVo::getUserId)
                              .eq(TUser::getUserId,userId)
                              .like(ProductVo::getProductName,seachTex)
                              .orderByDesc(ProductVo::getProductId));

        return page == null ? R.failed("查询失败！") : R.ok(page).setCode(1).setMsg(null);
    }

    @Override
    public R selectById(Integer id) {

        ProductVo product = getById(id);

        return product == null ? R.failed("查询失败！") : R.ok(product).setCode(1).setMsg(null);
    }

    @Override
    public R selectList(Integer id) {

        List<ProductVo> list = list(new MPJLambdaWrapper<ProductVo>()
                              .eq(ProductVo::getProductLineId, id)
                              .select(ProductVo::getProductName)
                              .orderByDesc(ProductVo::getProductId));

        return list == null ? R.failed("查询失败！") : R.ok(list).setCode(1).setMsg(null);
    }

    @Override
    public R insert(ProductVo product) {

        ProductVo one = getOne(new LambdaQueryWrapper<ProductVo>()
                       .eq(ProductVo::getProductName, product.getProductName())
                       .eq(ProductVo::getProductLineId, product.getProductLineId()));

        if(one != null)return R.failed("产品标题已重复!").setCode(0);

        boolean save = save(product);

        return save ? R.ok(save).setCode(1).setMsg("保存成功") : R.failed("保存失败！");
    }

    @Override
    public R update(ProductVo product) {

        ProductVo one = getOne(new LambdaQueryWrapper<ProductVo>()
                       .eq(ProductVo::getProductName, product.getProductName())
                       .eq(ProductVo::getProductLineId, product.getProductLineId())
                       .ne(ProductVo::getProductId,product.getProductId()));

        if(one != null)return R.failed("产品标题已重复!").setCode(0);

        boolean update = updateById(product);

        return update ? R.ok(update).setCode(1).setMsg("保存成功") : R.failed("保存失败！");
    }

    @Override
    public R deleteById(Integer id) {

        boolean remove = removeById(id);

        return remove ? R.ok(remove).setCode(1).setMsg("删除成功") : R.failed("删除失败！");
    }
}
