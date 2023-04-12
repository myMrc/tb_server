package com.gx.controller;


import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.gx.entity.TProductline;
import com.gx.entity.TUser;
import com.gx.service.ITProductlineService;
import com.gx.vo.ProductLineVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2023-03-18
 */
@RestController
@RequestMapping("/productline")
public class TProductlineController {

    @Autowired
    ITProductlineService productlineService;

    @GetMapping
    public R select(Principal principal, String seachTex, Integer current, Integer size){

        //Integer userId = JSONUtil.toBean(principal.getName(), TUser.class).getUserId();

        Integer userId = Integer.parseInt(principal.getName());

        return productlineService.select(userId,seachTex,current,size);
    }

    @GetMapping("/{id}")
    public R selectById(@PathVariable int id){

        return productlineService.selectById(id);
    }

    @GetMapping("/li")
    public R selectList(Principal principal){

        Integer userId = Integer.parseInt(principal.getName());

        return productlineService.selectList(userId);
    }

    @PostMapping
    public R insert(@RequestBody ProductLineVo productline, Principal principal){

        if(StringUtils.isEmpty(productline.getProductLineName()))return R.failed("请输入产品线名称！").setCode(0);

        Integer userId = Integer.parseInt(principal.getName());

        productline.setUserId(userId);

        return productlineService.insert(productline);
    }

    @PutMapping
    public R update(@RequestBody ProductLineVo productline){

        if(StringUtils.isEmpty(productline.getProductLineName()))return R.failed("请输入产品线名称！").setCode(0);

        return productlineService.update(productline);
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id){

        return productlineService.deleteById(id);
    }
}
