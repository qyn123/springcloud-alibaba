package com.qiaoyn.dao;

import com.qiao.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author qiaoyanan
 * date:2022/07/16 17:56
 */
@Mapper
public interface ProductDao {

    @Select("select * from product where p_id = #{pid}")
    Product selectById(Integer pid);

    @Update("update product set stock = #{stock} where p_id = #{pId}")
    void update(Product product);
}
