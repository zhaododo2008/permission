package com.codeshare.permission.category.resp;

/**
 * Created by zhaojun on 2018/12/30.
 **/

public class CategoryNode {

    /**
     * 类目id
     */
    private Integer id;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 父类目id
     */
    private Integer parentId;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 数据状态 0-正常,1-删除
     */
    private Integer delFlag;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
