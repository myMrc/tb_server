package com.gx.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TProductline;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-03-18
 */
public interface ITProductlineService extends IService<TProductline> {

    R selectProductline(Integer userId, String seachTex);

    R addProductline(Integer userId, TProductline productline);

    R updateProductline(TProductline productline);
}
