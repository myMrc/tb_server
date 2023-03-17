package com.gx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.Product;
import com.gx.entity.Productline;
import com.gx.mapper.ProductMapper;
import com.gx.service.IProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Override
    public R selectSupPro(int userId) {
        List<Product> list = list(new LambdaQueryWrapper<Product>().eq(Product::getProductID, userId));
        return list == null? R.failed("查询失败") : R.ok(list).setCode(1).setMsg(null);
    }
}
