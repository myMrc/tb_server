package com.gx.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TReseller;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-03-18
 */
public interface ITResellerService extends IService<TReseller> {

    R addReseller(TReseller reseller);
}
