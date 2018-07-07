package com.codeshare.permission.product.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Product implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 长
     */
    private Integer length;

    /**
     * 宽
     */
    private Integer width;

    /**
     * 高
     */
    private Integer height;

    /**
     * 来源 1:DR系统 2:BOSS系统
     */
    private Short source;

    /**
     * 类目id
     */
    private Integer categoryId;

    /**
     * 品牌id
     */
    private Integer brandId;

    /**
     * 风格id
     */
    private Integer styleId;

    /**
     * 系列id
     */
    private Integer seriesId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 风格名称
     */
    private String styleName;

    /**
     * 系列名称
     */
    private String seriesName;

    /**
     * 1: 删除 0: 未删除
     */
    private Short delFlag;

    /**
     * 0:下架；1:上架
     */
    private Short status;

    /**
     * 商品类型 0:普通商品
     */
    private Integer type;

    /**
     * 添加人
     */
    private Integer addUserId;

    /**
     * 更新人
     */
    private Integer updUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 最后上下架时间
     */
    private Date lastShelfTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Short getSource() {
        return source;
    }

    public void setSource(Short source) {
        this.source = source;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Short getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(Integer addUserId) {
        this.addUserId = addUserId;
    }

    public Integer getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(Integer updUserId) {
        this.updUserId = updUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastShelfTime() {
        return lastShelfTime;
    }

    public void setLastShelfTime(Date lastShelfTime) {
        this.lastShelfTime = lastShelfTime;
    }
}