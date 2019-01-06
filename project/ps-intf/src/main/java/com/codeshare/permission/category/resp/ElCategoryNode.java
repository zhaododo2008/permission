package com.codeshare.permission.category.resp;

import java.util.List;

/**
 *
 * @author zhaojun
 * @date 2019/1/1
 **/

public class ElCategoryNode {

    public ElCategoryNode(){
    }

    /**
     * key
     */
    private Integer value = 0;

    /**
     * name
     */
    private String label = "";


    /**
     * 子树
     */
    private List<ElCategoryNode> children;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ElCategoryNode> getChildren() {
        return children;
    }

    public void setChildren(List<ElCategoryNode> children) {
        this.children = children;
    }
}
