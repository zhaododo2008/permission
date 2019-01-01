package com.codeshare.permission.category.facade.impl;

import com.codeshare.permission.category.facade.ICategoryQueryFacade;
import com.codeshare.permission.category.req.CategoryQueryParamVo;
import com.codeshare.permission.category.resp.ElCategoryNode;
import com.codeshare.permission.category.service.ICategoryQueryService;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author zhaojun
 * @date 2019/1/1
 **/

@Resource
public class CategoryQueryFacadeImpl implements ICategoryQueryFacade {

    @Resource
    private ICategoryQueryService queryService;

    @Override
    public List<ElCategoryNode> queryElNodeTree(CategoryQueryParamVo queryParamVo) {
        return queryService.queryElNodeTree(queryParamVo);
    }

}
