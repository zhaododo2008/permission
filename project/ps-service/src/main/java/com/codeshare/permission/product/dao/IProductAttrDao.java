package com.codeshare.permission.product.dao;

import com.codeshare.permission.product.po.ProductAttr;

public interface IProductAttrDao {
    int deleteByPrimaryKey(Long id);

    int insert(ProductAttr record);

    int insertSelective(ProductAttr record);

    ProductAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductAttr record);

    int updateByPrimaryKey(ProductAttr record);
}