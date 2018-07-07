package com.codeshare.permission.servcie.test;

import com.codeshare.permission.base.BaseTest;
import com.codeshare.permission.product.req.ProductSaveReq;
import com.codeshare.permission.product.service.IProductFacade;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by zhaojun on 2018/7/7.
 **/

public class ProductFacadeTest extends BaseTest {

    protected static final Logger logger = LoggerFactory.getLogger(ProductFacadeTest.class);

    @Resource
    private IProductFacade productFacade;

    @Test
    public void testSaveProduct() throws Exception {

        ProductSaveReq saveReq = new ProductSaveReq();
        saveReq.setAddUserId(1);
        saveReq.setBrandId(1);
        saveReq.setName("asdsdf");
        saveReq.setHeadImage("a.jpg");
        saveReq.setProductContent("content");
        saveReq.setType(1);
        saveReq.setSalePrice(new BigDecimal(12.0));

        saveReq.setDetailImages(Lists.newArrayList("a.jpg","b.jpg"));
        productFacade.saveProduct(saveReq);
        logger.info("finished ");
    }
}
