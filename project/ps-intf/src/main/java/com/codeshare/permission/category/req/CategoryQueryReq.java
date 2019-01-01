package com.codeshare.permission.category.req;

import java.util.Date;

/**
 * @author
 */
public class CategoryQueryReq implements java.io.Serializable{

    /**
     * 类目id
     */
    private Integer categoryId;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 父类目id
     */
    private Integer parentId;

    /**
     * 排序顺序
     */
    private Short sort;

    /**
     * 类目层级 1 2 3
     */
    private Short level;

    /**
     * 类目类型
     */
    private Short type;

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
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