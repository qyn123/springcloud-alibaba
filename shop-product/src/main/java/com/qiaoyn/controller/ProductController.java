package com.qiaoyn.controller;

import com.qiao.entity.Product;
import com.qiaoyn.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public void reduceInventory(@RequestParam("pid") Integer pid,@RequestParam("num")  int num) {
        productService.reduceInventory(pid, num);
    }
}
