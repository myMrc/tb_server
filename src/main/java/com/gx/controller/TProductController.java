package com.gx.controller;


import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TProduct;
import com.gx.entity.TUser;
import com.gx.service.ITProductService;
import com.gx.vo.ProductVo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2023-03-24
 */
@RestController
@RequestMapping("/product")
public class TProductController {

    @Resource
    ITProductService productService;

    @GetMapping
    public R select(Principal principal, String seachTex, Integer current, Integer size){

        Integer userId = Integer.parseInt(principal.getName());

        return productService.select(userId,seachTex,current,size);
    }

    @GetMapping("/{id}")
    public R selectById(@PathVariable Integer id){

        return productService.selectById(id);
    }

    @GetMapping("/li/{id}")
    public R selectList(@PathVariable Integer id){

        return productService.selectList(id);
    }

    @PostMapping
    public R insert(@RequestBody ProductVo product){

        if(StringUtils.isEmpty(product.getProductName()))return R.failed("请输入产品标题！").setCode(0);

        return productService.insert(product);
    }

    @PutMapping
    public R update(@RequestBody ProductVo product){

        if(StringUtils.isEmpty(product.getProductName()))return R.failed("请输入产品标题！").setCode(0);

        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id){

        return productService.deleteById(id);
    }
}
