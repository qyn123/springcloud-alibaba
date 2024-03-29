package com.qiao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qiaoyanan
 * date:2022/07/16 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private Integer pId;//主键
    private String pName;//商品名称
    private Double pPrice;//商品价格
    private Integer stock;//库存
    private String dataBase;
}
