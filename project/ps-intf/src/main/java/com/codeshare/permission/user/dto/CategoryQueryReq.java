package com.codeshare.permission.user.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 权限查询传输对象
 * @author cjbi
 */
@ApiModel("权限传输对象")
public class CategoryQueryReq {

    @ApiModelProperty(value = "用户编号",required = true)
    @NotNull
    private Integer userId;

    @ApiModelProperty(value = "上级资源id")
    @NotNull
    private Integer parentId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

}
