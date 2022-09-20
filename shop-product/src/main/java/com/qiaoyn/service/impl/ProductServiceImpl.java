package com.qiaoyn.service.impl;

import com.qiao.entity.Product;
import com.qiaoyn.dao.ProductDao;
import com.qiaoyn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author qiaoyanan
 * date:2022/07/16 17:57
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findByPid(Integer pid) {
        return productDao.selectById(pid);
    }

    @Override
    public void reduceInventory(Integer pid, int num) {
        Product product = productDao.selectById(pid);
        if (product.getStock() < num) {
            throw new RuntimeException("库存不足");
        }
        product.setStock(product.getStock() - num);
        //如果发生异常,则回滚
        //减库存
        productDao.update(product);
        int i = 1 / 0;
    }
}
