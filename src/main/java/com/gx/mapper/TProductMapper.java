package com.gx.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseMapper;
import com.gx.entity.TProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gx.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2023-03-24
 */
@Mapper
public interface TProductMapper extends MPJBaseMapper<ProductVo> {
}
