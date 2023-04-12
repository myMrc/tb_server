package com.gx.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gx.vo.ProductLineVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author
 * @since 2023-03-18
 */
public interface ITProductlineService extends IService<ProductLineVo> {

    R select(Integer userId, String seachTex, Integer current, Integer size);

    R selectById(Integer id);

    R selectList(Integer userId);

    R insert(ProductLineVo productline);

    R update(ProductLineVo productline);

    R deleteById(Integer id);
}
