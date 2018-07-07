package com.codeshare.permission.product.req;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhaojun on 2018/7/6.
 **/

public class ProductSaveReq implements Serializable {
    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private Integer productId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String name;

    /**
     * 长
     */
    @ApiModelProperty(value = "长")
    private Integer length;

    /**
     * 宽
     */
    @ApiModelProperty(value = "宽")
    private Integer width;

    /**
     * 高
     */
    @ApiModelProperty(value = "高")
    private Integer height;

    /**
     * 类目id
     */
    @ApiModelProperty(value = "类别id")
    private Integer categoryId;

    /**
     * 类目名称
     */
    @ApiModelProperty(value = "类别名称")
    private String categoryName;

    /**
     * 品牌id
     */
    @ApiModelProperty(value = "品牌id")
    private Integer brandId;

    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    /**
     * 采购价
     */
    @ApiModelProperty(value = "采购价")
    private BigDecimal purchasePrice;

    /**
     * 销售价
     */
    @ApiModelProperty(value = "销售价")
    private BigDecimal salePrice;

    /**
     * 市场价（原价）
     */
    @ApiModelProperty(value = "市场价")
    private BigDecimal marketPrice;

    /**
     * 商品头图
     */
    @ApiModelProperty(value = "商品头图")
    private String headImage;

    /**
     * 商品明细图片
     */
    @ApiModelProperty(value = "商品明细图")
    private List<String> detailImages;

    /**
     * 商品类型
     */
    @ApiModelProperty(value = "商品类型")
    private Integer type;

    /**
     * 商品明细内容
     */
    @ApiModelProperty(value = "商品明细内容")
    private String productContent;

    /**
     * 添加人
     */
    @ApiModelProperty(value = "添加人")
    private Integer addUserId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public List<String> getDetailImages() {
        return detailImages;
    }

    public void setDetailImages(List<String> detailImages) {
        this.detailImages = detailImages;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public Integer getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(Integer addUserId) {
        this.addUserId = addUserId;
    }
}
