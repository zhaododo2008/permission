package com.codeshare.permission.category.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhaojun on 2018/12/30.
 **/

@ApiModel(description = "查询类目入参")
public class CategoryQueryParamVo {

    @ApiModelProperty(value = "类目id")
    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
