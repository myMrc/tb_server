package com.gx.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gx.vo.ProductVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-03-24
 */
public interface ITProductService extends IService<ProductVo> {

    R select(Integer userId, String seachTex, Integer current, Integer size);

    R selectById(Integer id);

    R selectList(Integer id);

    R insert(ProductVo product);

    R update(ProductVo product);

    R deleteById(Integer id);
}
