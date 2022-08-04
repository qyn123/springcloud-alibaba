package com.qiaoyn.service;

import com.qiao.entity.Product;
import com.qiaoyn.config.ProductServiceFallBack;
import com.qiaoyn.config.ProductServiceFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
public interface ProductFeignService {

    //指定调用提供者的哪个方法
    // @FeignClient+@GetMapping 就是一个完整的请求路径 http://service-product/product{pid}
    @GetMapping(value = "/product/{pid}")
    Product findByPid(@PathVariable("pid") Integer pid);
}
