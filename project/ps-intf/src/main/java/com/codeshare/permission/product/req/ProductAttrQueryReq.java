package com.codeshare.permission.product.req;

import java.io.Serializable;

/**
 * @author zhaododo
 **/

public class ProductAttrQueryReq implements Serializable {

    /**
     * 商品Id
     */
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
