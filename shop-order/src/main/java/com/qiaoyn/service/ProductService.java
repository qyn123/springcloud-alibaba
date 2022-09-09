package com.qiaoyn.service;

import com.qiao.entity.Product;
import com.qiaoyn.config.ProductServiceFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qiaoyanan
 * date:2022/07/19 9:31
 */
//value用于指定调用nacos下哪个微服务
// fallback用于指定容错类
@FeignClient(value = "service-product",
        //fallback = ProductServiceFallBack.class
        fallbackFactory = ProductServiceFallBackFactory.class
)
public interface ProductService {

    //减库存
    @RequestMapping("/product/reduceInventory")
    void reduceInventory(@RequestParam("pid") Integer pid, @RequestParam("num") int num);
}
