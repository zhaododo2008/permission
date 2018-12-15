package com.codeshare.permission.product.service.impl;

import com.codeshare.common.CodeHelperUtil;
import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.product.dao.IProductAttrDao;
import com.codeshare.permission.product.dao.IProductDao;
import com.codeshare.permission.product.dao.IProductFileDao;
import com.codeshare.permission.product.dao.IProductPriceDao;
import com.codeshare.permission.product.po.Product;
import com.codeshare.permission.product.po.ProductAttr;
import com.codeshare.permission.product.po.ProductFile;
import com.codeshare.permission.product.po.ProductPrice;
import com.codeshare.permission.product.req.ProductAttrReq;
import com.codeshare.permission.product.req.ProductReq;
import com.codeshare.permission.product.service.IProductService;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.codeshare.permission.product.constant.ProductFileType.DETAIL_IMAGE;
import static com.codeshare.permission.product.constant.ProductFileType.HEAD_IMAGE;

/**
 * Created by zhaojun on 2018/7/6.
 **/

@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    private IProductDao productDao;

    @Resource
    private IProductPriceDao priceDao;

    @Resource
    private IProductFileDao fileDao;

    @Resource
    private IProductAttrDao attrDao;

    @Override
    public void saveProduct(ProductReq req) {
        Long productId = saveCommonInfo(req);
        saveProductPrice(req, productId);
        saveProductFiles(req, productId);
        saveProductDetail(req, productId);
    }

    private void saveProductDetail(ProductReq req, Long productId) {
        List<ProductAttr> productDetails = queryProductDetails(productId);
        ProductAttr productDetail = buildProductAttr(req, productId);
        if (CodeHelperUtil.isNotEmpty(productDetails)){
            updProductAttr(productDetail);
        }
        else{
            addProductDetail(productDetail);
        }
    }

    private void updProductAttr(ProductAttr productAttr) {
        attrDao.updateByPrimaryKeySelective(productAttr);
    }

    private void addProductDetail(ProductAttr productAttr) {
        attrDao.insertSelective(productAttr);
    }

    private List<ProductAttr> queryProductDetails(Long productId) {
        ProductAttrReq detailReq = new ProductAttrReq();
        detailReq.setProductId(productId);
        return attrDao.queryList(detailReq);
    }

    private ProductAttr buildProductAttr(ProductReq req, Long productId) {
        ProductAttr productAttr = new ProductAttr();
        productAttr.setProductId(productId);
        productAttr.setAttrInfo(req.getProductContent());
        return productAttr;
    }

    private void saveProductPrice(ProductReq req, Long productId) {
        ProductPrice productPrice = ModelMapperUtil.strictMap(req,ProductPrice.class);
        productPrice.setProductId(productId);
        productPrice.setPurchasePrice(req.getPurchasePrice());
        productPrice.setSalePrice(req.getSalePrice());
        priceDao.insertSelective(productPrice);
    }

    /**
     * 保存商品文件
     * @param req
     * @param productId
     */
    private void saveProductFiles(ProductReq req, Long productId) {
        List<ProductFile> productFiles = buildProductFiles(req, productId);
        addProductFile(productFiles);
    }

    private void addProductFile(List<ProductFile> productFiles) {
        for (ProductFile productFile:productFiles) {
            fileDao.insertSelective(productFile);
        }
    }

    private List<ProductFile> buildProductFiles(ProductReq req, Long productId) {
        List<ProductFile> productFiles = Lists.newArrayList();
        if (CodeHelperUtil.isNotEmpty(req.getHeadImage())){
            ProductFile file = new ProductFile();
            file.setProductId(productId);
            file.setType(HEAD_IMAGE);
            file.setUrl(req.getHeadImage());
            file.setAddUserId(req.getAddUserId());
            productFiles.add(file);
        }

        if (CollectionUtils.isNotEmpty(req.getDetailImages())) {
            for (String url : req.getDetailImages()) {
                ProductFile file = new ProductFile();
                file.setProductId(productId);
                file.setType(DETAIL_IMAGE);
                file.setUrl(url);
                file.setAddUserId(req.getAddUserId());
                productFiles.add(file);
            }
        }
        return productFiles;
    }

    /**
     * 保存商品基本信息
     * @param req
     * @return
     */
    private Long saveCommonInfo(ProductReq req) {
        Product product = ModelMapperUtil.strictMap(req,Product.class);
        if (CodeHelperUtil.isPositive(req.getId())){
            updCommonInfo(product);
        }
        else{
            addCommonInfo(product);
        }
        return product.getId();
    }

    private void updCommonInfo(Product product) {
        productDao.updateByPrimaryKeySelective(product);
    }

    private void addCommonInfo(Product product) {
        productDao.insertSelective(product);
    }
}
