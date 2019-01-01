package com.codeshare.permission.category.service;

import com.codeshare.permission.category.po.Category;
import com.codeshare.permission.category.req.CategoryQueryParamVo;
import com.codeshare.permission.category.req.CategoryQueryReq;
import com.codeshare.permission.category.resp.CategoryTreeNode;

import java.util.List;

/**
 *
 * @author zhaojun
 * @date 2018/12/30
 **/

public interface ICategoryQueryService {


    /**
     * 查询所有叶子节点（如果不传，构造一棵树）
     * @param queryParamVo
     * @return
     */
    CategoryTreeNode queryLeafNodes(CategoryQueryParamVo queryParamVo);


    /**
     * 查询类目列表
     * @param queryReq
     * @return
     */
    List<Category> queryList(CategoryQueryReq queryReq);


}
