package com.codeshare.permission.product.service.impl;

import com.codeshare.common.CodeHelperUtil;
import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.product.req.ProductReq;
import com.codeshare.permission.product.req.ProductSaveReq;
import com.codeshare.permission.product.service.IProductFacade;
import com.codeshare.permission.product.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 * @author zhaojun
 * @date 2018/7/6
 **/

@Service
public class ProductFacadeImpl implements IProductFacade {

    @Resource
    private IProductService productService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveProduct(ProductSaveReq saveReq) {

        ProductReq productReq = buildProductReq(saveReq);
        productService.saveProduct(productReq);
    }

    private ProductReq buildProductReq(ProductSaveReq saveReq) {
        ProductReq productReq = ModelMapperUtil.strictMap(saveReq, ProductReq.class);
        if (CodeHelperUtil.isPositive(saveReq.getProductId())){
            productReq.setId(saveReq.getProductId());
        }
        return productReq;
    }
}
