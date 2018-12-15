package com.codeshare.permission.product.dao;

import com.codeshare.permission.product.po.ProductAttr;
import com.codeshare.permission.product.req.ProductAttrQueryReq;
import org.apache.ibatis.annotations.Param;

public interface IProductAttrDao {
    int deleteByPrimaryKey(Long id);

    int insert(ProductAttr record);

    int insertSelective(ProductAttr record);

    ProductAttr selectByPrimaryKey(Long id);

    ProductAttr querySingle(@Param("req") ProductAttrQueryReq queryReq);

    int updateByPrimaryKeySelective(ProductAttr record);

    int updateByPrimaryKey(ProductAttr record);
}