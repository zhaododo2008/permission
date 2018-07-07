package com.codeshare.permission.product.dao;

import com.codeshare.permission.product.po.ProductPrice;

public interface IProductPriceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductPrice record);

    int insertSelective(ProductPrice record);

    ProductPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductPrice record);

    int updateByPrimaryKey(ProductPrice record);
}