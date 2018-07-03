package com.codeshare.permission.user.dto;

import com.codeshare.permission.user.enums.Source;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author cjbi
 */
@ApiModel("资源树请求")
public class ResourceTreeReq {

    @ApiModelProperty("用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

    @ApiModelProperty("用户来源")
    @NotNull(message = "用户来源不能为空")
    private Source source;

    @ApiModelProperty("系统id")
    @NotNull(message = "系统id不能为空")
    private Integer systemId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }
}
