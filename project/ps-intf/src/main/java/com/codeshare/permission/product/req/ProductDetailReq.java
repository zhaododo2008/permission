package com.codeshare.permission.product.req;

import java.io.Serializable;

/**
 * Created by zhaojun on 2018/7/6.
 **/

public class ProductDetailReq implements Serializable {

    /**
     * 商品Id
     */
    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
