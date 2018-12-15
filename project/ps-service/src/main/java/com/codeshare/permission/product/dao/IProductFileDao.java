package com.codeshare.permission.product.dao;

import com.codeshare.permission.product.po.ProductFile;

public interface IProductFileDao {
    int deleteByPrimaryKey(Long id);

    int insert(ProductFile record);

    int insertSelective(ProductFile record);

    ProductFile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductFile record);

    int updateByPrimaryKey(ProductFile record);
}