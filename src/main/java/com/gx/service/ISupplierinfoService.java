package com.gx.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.Supplierinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mrc
 * @since 2023-03-09
 */
public interface ISupplierinfoService extends IService<Supplierinfo> {

    R selectSup(Integer userId);

    R updateSup(Supplierinfo sup);
}
