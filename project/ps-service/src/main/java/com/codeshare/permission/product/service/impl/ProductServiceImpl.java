package com.codeshare.permission.product.service.impl;

import com.codeshare.common.CodeHelperUtil;
import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.product.dao.IProductDao;
import com.codeshare.permission.product.dao.IProductDetailDao;
import com.codeshare.permission.product.dao.IProductFileDao;
import com.codeshare.permission.product.dao.IProductPriceDao;
import com.codeshare.permission.product.po.Product;
import com.codeshare.permission.product.po.ProductDetail;
import com.codeshare.permission.product.po.ProductFile;
import com.codeshare.permission.product.po.ProductPrice;
import com.codeshare.permission.product.req.ProductDetailReq;
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
    private IProductDetailDao detailDao;

    @Override
    public void saveProduct(ProductReq req) {
        Integer productId = saveCommonInfo(req);
        saveProductPrice(req, productId);
        saveProductFiles(req, productId);
        saveProductDetail(req, productId);
    }

    private void saveProductDetail(ProductReq req, Integer productId) {
        List<ProductDetail> productDetails = queryProductDetails(productId);
        ProductDetail productDetail = buildProductDetail(req, productId);
        if (CodeHelperUtil.isNotEmpty(productDetails)){
            updProductDetail(productDetail);
        }
        else{
            addProductDetail(productDetail);
        }
    }

    private void updProductDetail(ProductDetail productDetail) {
        detailDao.updateByPrimaryKeyWithBLOBs(productDetail);
    }

    private void addProductDetail(ProductDetail productDetail) {
        detailDao.insertSelective(productDetail);
    }

    private List<ProductDetail> queryProductDetails(Integer productId) {
        ProductDetailReq detailReq = new ProductDetailReq();
        detailReq.setProductId(productId);
        return detailDao.queryList(detailReq);
    }

    private ProductDetail buildProductDetail(ProductReq req, Integer productId) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productId);
        productDetail.setContent(req.getProductContent());
        return productDetail;
    }

    private void saveProductPrice(ProductReq req, Integer productId) {
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
    private void saveProductFiles(ProductReq req, Integer productId) {
        List<ProductFile> productFiles = buildProductFiles(req, productId);
        addProductFile(productFiles);
    }

    private void addProductFile(List<ProductFile> productFiles) {
        for (ProductFile productFile:productFiles) {
            fileDao.insertSelective(productFile);
        }
    }

    private List<ProductFile> buildProductFiles(ProductReq req, Integer productId) {
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
    private Integer saveCommonInfo(ProductReq req) {
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
