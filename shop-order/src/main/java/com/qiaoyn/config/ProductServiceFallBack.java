package com.qiaoyn.config;

import com.qiao.entity.Product;
import com.qiaoyn.service.ProductFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author qiaoyanan
 * date:2022/08/02 15:31
 */
@Component
@Slf4j
public class ProductServiceFallBack implements ProductFeignService {
    @Override
    public Product findByPid(Integer pid) {
        Product product = new Product();
        product.setPId(-1);
        return product;
    }
}
