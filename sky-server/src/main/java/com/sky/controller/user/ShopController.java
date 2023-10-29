package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/user/shop")
@Api(tags = "商店相关接口")
@RestController("userShopController")
public class ShopController {
    @Autowired
    private RedisTemplate redisTemplate;
    public static final String key ="SHOP_STATUS";

    @GetMapping("/{status}")
    @ApiOperation("获取店铺营业状态")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get(key);
        log.info("店铺的营业状态为{}",status);
        return Result.success(status);


    }
}
