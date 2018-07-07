package com.codeshare.permission.controller;

import com.codeshare.permission.common.ResponseVo;
import com.codeshare.permission.product.req.ProductSaveReq;
import com.codeshare.permission.product.service.IProductFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by zhaojun on 2018/7/7.
 **/

@RestController
@RequestMapping("/admin")
@Api(tags="【ps-web】商品接口")
public class ProductController {

    @Resource
    private IProductFacade productFacade;

    @ApiOperation("保存商品")
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseVo saveProduct(@RequestBody @Valid ProductSaveReq saveReq) {
        productFacade.saveProduct(saveReq);
        return ResponseVo.success();
    }
}
