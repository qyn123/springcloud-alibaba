package com.qiaoyn.controller;

import com.qiao.entity.Product;
import com.qiaoyn.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author qiaoyanan
 * date:2022/07/16 18:00
 */
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        return productService.findByPid(pid);
    }

    //减少库存
    @RequestMapping("/product/reduceInventory")
    public void reduceInventory(Integer pid, int num) {
        productService.reduceInventory(pid, num);
    }
}
