package com.qiaoyn.service;

import com.qiao.entity.Product;

import java.util.Optional;

/**
 * @author qiaoyanan
 * date:2022/07/16 17:57
 */
public interface ProductService {

    Product findByPid(Integer pid);

    void reduceInventory(Integer pid, int num);
}
