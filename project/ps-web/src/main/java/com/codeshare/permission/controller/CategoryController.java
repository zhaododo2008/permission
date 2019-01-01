package com.codeshare.permission.controller;

import com.codeshare.permission.category.req.CategoryQueryParamVo;
import com.codeshare.permission.category.resp.CategoryTreeNode;
import com.codeshare.permission.category.resp.ElCategoryNode;
import com.codeshare.permission.category.service.ICategoryQueryService;
import com.codeshare.permission.common.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author zhaojun
 * @date 2019/1/1
 **/

@RestController
@RequestMapping("/admin")
@Api(tags="【ps-web】类目接口")
public class CategoryController {

    @Resource
    private ICategoryQueryService categoryQueryService;
    @ApiOperation("查询类目列表")
    @RequestMapping(value = "/queryCategoryList", method = RequestMethod.POST)
    public ResponseVo<CategoryTreeNode> queryCategoryList(@RequestBody CategoryQueryParamVo queryParamVo) {
        return ResponseVo.success(categoryQueryService.queryLeafNodes(queryParamVo));
    }


    @ApiOperation("查询El类目列表")
    @RequestMapping(value = "/queryElCategoryList", method = RequestMethod.POST)
    public ResponseVo<ElCategoryNode> queryElCategoryList(@RequestBody CategoryQueryParamVo queryParamVo) {
        return ResponseVo.success(categoryQueryService.queryElNodeTree(queryParamVo));
    }
}
