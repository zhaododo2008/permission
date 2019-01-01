package com.codeshare.permission.category.service.impl;

import com.codeshare.common.CodeHelperUtil;
import com.codeshare.permission.category.constants.CategroyConstants;
import com.codeshare.permission.category.dao.ICategoryDao;
import com.codeshare.permission.category.po.Category;
import com.codeshare.permission.category.req.CategoryQueryParamVo;
import com.codeshare.permission.category.req.CategoryQueryReq;
import com.codeshare.permission.category.resp.CategoryNode;
import com.codeshare.permission.category.resp.CategoryTreeNode;
import com.codeshare.permission.category.service.ICategoryQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author zhaojun
 * @date 2019/1/1
 **/

@Service
public class CategoryQueryServiceImpl implements ICategoryQueryService {

    @Resource
    private  ICategoryDao categoryDao;

    @Override
    public CategoryTreeNode queryLeafNodes(CategoryQueryParamVo queryParamVo) {

        List<Category> rootCategoryList = queryCategoryById(queryParamVo);
        CategoryTreeNode rootTreeNode = buildRootTreeNode(rootCategoryList);
        List<Category> allCategory = queryAllCategory();
        buildCategoryTree(rootTreeNode,allCategory);
        return rootTreeNode;
    }

    private CategoryTreeNode buildRootTreeNode(List<Category> rootCategoryList) {
        CategoryTreeNode categoryTreeNode = new CategoryTreeNode();
        if (CodeHelperUtil.isNotEmpty(rootCategoryList)){
            CategoryNode categoryNode = buildRootCategoryNode(rootCategoryList);
            categoryTreeNode.setCategoryNode(categoryNode);
        }
        else{
            CategoryNode categoryNode = buildDefaultCategoryNode();
            categoryTreeNode.setCategoryNode(categoryNode);
        }

        return categoryTreeNode;
    }

    @Override
    public List<Category> queryList(CategoryQueryReq queryReq) {
        return categoryDao.queryList(queryReq);
    }

    private void buildCategoryTree(CategoryTreeNode root, List<Category> categoryList) {

        if (CodeHelperUtil.isNotEmpty(categoryList)){
            for (Category category : categoryList) {
                if (category.getParentId().equals(root.getCategoryNode().getId())) {
                    CategoryTreeNode childNode = new CategoryTreeNode();
                    CategoryNode categoryNode = buildCategoryNode(category);
                    childNode.setCategoryNode(categoryNode);
                    buildCategoryTree(childNode, categoryList);
                    root.getChildren().add(childNode);
                }
            }
        }
    }

    private CategoryNode buildRootCategoryNode(List<Category> categoryList) {
        Category category = categoryList.get(0);
        CategoryNode categoryNode = new CategoryNode();
        categoryNode.setId(category.getCategoryId());
        categoryNode.setParentId(category.getParentId());
        categoryNode.setName(category.getName());
        categoryNode.setLevel(category.getLevel().intValue());
        return categoryNode;
    }

    private CategoryNode buildDefaultCategoryNode() {
        CategoryNode categoryNode = new CategoryNode();
        categoryNode.setLevel(0);
        categoryNode.setId(1);
        categoryNode.setName(null);
        categoryNode.setParentId(0);
        return categoryNode;
    }

    private CategoryNode buildCategoryNode(Category category) {
        CategoryNode categoryNode = new CategoryNode();
        categoryNode.setId(category.getCategoryId());
        categoryNode.setParentId(category.getParentId());
        categoryNode.setName(category.getName());
        categoryNode.setLevel(category.getLevel().intValue());
        return categoryNode;
    }

    private List<Category> queryAllCategory(){
        CategoryQueryReq queryReq = new CategoryQueryReq();
        queryReq.setDelFlag(CategroyConstants.Status.NORMAL);
        return queryList(queryReq);
    }

    private List<Category> queryCategoryById(CategoryQueryParamVo queryParamVo) {
        CategoryQueryReq queryReq = new CategoryQueryReq();
        queryReq.setDelFlag(CategroyConstants.Status.NORMAL);
        if (CodeHelperUtil.isPositive(queryParamVo.getCategoryId())) {
            queryReq.setCategoryId(queryParamVo.getCategoryId());
        } else {
            queryReq.setCategoryId(0);
        }
        return queryList(queryReq);
    }
}
