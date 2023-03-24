package com.gx.mapper;

import com.gx.entity.TProductline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2023-03-18
 */
@Mapper
public interface TProductlineMapper extends BaseMapper<TProductline> {

    List<TProductline> listProductline(@Param("userId") Integer userId, @Param("seachTex") String seachTex);

    int oneProductline(@Param("userId") Integer userId, @Param("productLineName") String productLineName);
}
