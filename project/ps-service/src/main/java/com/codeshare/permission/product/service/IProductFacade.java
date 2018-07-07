package com.codeshare.permission.product.service;

import com.codeshare.permission.product.req.ProductSaveReq;

/**
 *
 * @author zhaojun
 * @date 2018/7/6
 **/

public interface IProductFacade {

    /**
     * 保存商品
     * @param saveReq
     * @return
     */
    void saveProduct(ProductSaveReq saveReq);
}
