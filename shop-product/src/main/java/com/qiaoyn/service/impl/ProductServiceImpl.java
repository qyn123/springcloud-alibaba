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
}
