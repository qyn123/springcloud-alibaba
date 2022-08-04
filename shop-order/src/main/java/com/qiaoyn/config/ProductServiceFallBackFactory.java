package com.qiaoyn.config;

import com.qiao.entity.Product;
import com.qiaoyn.service.ProductFeignService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author qiaoyanan
 * date:2022/08/02 15:54
 */
@Component
@Slf4j
public class ProductServiceFallBackFactory implements FallbackFactory<ProductFeignService> {
    @Override
    public ProductFeignService create(Throwable throwable) {
        return pid -> {
            throwable.printStackTrace();
            Product product = new Product();
            product.setPId(-1);
            return product;
        };
    }
}
