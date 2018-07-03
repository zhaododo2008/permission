package com.codeshare.permission.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author cjbi
 */
@ApiModel("控件")
public class Authority {

    @ApiModelProperty("控件ID")
    private String authorityId;

    @ApiModelProperty("是否可见")
    private boolean visibility;

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}