package com.codeshare.permission.category.facade;

import com.codeshare.permission.category.req.CategoryQueryParamVo;
import com.codeshare.permission.category.resp.ElCategoryNode;

import java.util.List;

/**
 *
 * @author zhaojun
 * @date 2019/1/1
 **/

public interface ICategoryQueryFacade {

    /**
     * 查询element-ui类目树
     * @param queryParamVo
     * @return
     */
    List<ElCategoryNode> queryElNodeTree(CategoryQueryParamVo queryParamVo);

}
