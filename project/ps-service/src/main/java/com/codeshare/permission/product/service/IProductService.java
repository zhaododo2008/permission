package com.codeshare.permission.product.service;

import com.codeshare.permission.product.req.ProductReq;

/**
 * Created by zhaojun on 2018/7/6.
 **/

public interface IProductService {

    /**
     * 保存商品基本信息
     * @param req
     */
    void saveProduct(ProductReq req);

}
