package com.codeshare.permission.category.resp;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author zhaojun
 * @date 2018/12/30
 **/

public class CategoryTreeNode {

    public CategoryTreeNode(){
        categoryNode = new CategoryNode();
        children = new LinkedList<>();
    }

    /**
     * 节点
     */
    private CategoryNode categoryNode;


    /**
     * 子树
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
