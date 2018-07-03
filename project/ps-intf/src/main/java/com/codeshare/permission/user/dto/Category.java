package com.codeshare.permission.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 *
 * @author cjbi
 */
@ApiModel("类目")
public class Category {

    @ApiModelProperty("类目名称")
    private String category;

    @ApiModelProperty("是否可见")
    private boolean visibility;

    @ApiModelProperty("子节点")
    List<Authority> child;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public List<Authority> getChild() {
        return child;
    }

    public void setChild(List<Authority> child) {
        this.child = child;
    }
}
