package com.codeshare.permission.category.resp;

import java.util.List;

/**
 * Created by zhaojun on 2018/12/30.
 **/

public class CategoryTreeNode {

    /**
     *
     */
    private CategoryNode categoryNode;


    /**
     * 子节点
     */
    private List<CategoryTreeNode> children;

    public CategoryNode getCategoryNode() {
        return categoryNode;
    }

    public void setCategoryNode(CategoryNode categoryNode) {
        this.categoryNode = categoryNode;
    }

    public List<CategoryTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryTreeNode> children) {
        this.children = children;
    }
}
