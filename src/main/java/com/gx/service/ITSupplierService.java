package com.gx.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TSupplier;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-03-18
 */
public interface ITSupplierService extends IService<TSupplier> {

    R selectSupplier(Integer userId);

    R addSupplier(TSupplier supplier);

    R updateSupplier(TSupplier supplier);
}
