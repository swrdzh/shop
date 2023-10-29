package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/admin/shop")
@Api(tags = "商店相关接口")
@RestController("adminShopController")
public class ShopController {
    @Autowired
    private RedisTemplate redisTemplate;

    public static final String key ="SHOP_STATUS";


    @PutMapping("/{status}")
    @ApiOperation("设置上商店状态")
    public Result setStatus(@PathVariable Integer status){
        log.info("设置店铺的营业状态：{}",status==1?"营业中":"打烊中");
        redisTemplate.opsForValue().set(key,status);
        return Result.success();
    }

    @GetMapping("/{status}")
    @ApiOperation("获取店铺营业状态")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get(key);
        log.info("店铺的营业状态为{}",status);
        return Result.success(status);


    }
}
