package com.codeshare.permission.product.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class ProductFile implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 文件名称
     */
    private String fName;

    /**
     * 1:缩略图 2:明细图
     */
    private Integer type;

    /**
     * 图片url
     */
    private String url;

    /**
     * 添加人
     */
    private Integer addUserId;

    /**
     * 更新人
     */
    private Integer updUserId;

    /**
     * 1: 删除 0: 未删除
     */
    private Short delFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Short getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
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
}