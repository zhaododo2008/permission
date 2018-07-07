package com.codeshare.permission.product.dao;

import com.codeshare.permission.product.po.ProductDetail;
import com.codeshare.permission.product.req.ProductDetailReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProductDetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Integer id);

    List<ProductDetail> queryList(@Param("req")ProductDetailReq req);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKeyWithBLOBs(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);
}