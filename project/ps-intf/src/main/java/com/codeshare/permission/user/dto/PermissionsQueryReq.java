package com.codeshare.permission.user.dto;

import com.codeshare.permission.user.enums.ResourceType;
import com.codeshare.permission.user.enums.Source;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 权限查询传输对象
 * @author cjbi
 */
@ApiModel("权限传输对象")
public class PermissionsQueryReq {

    @ApiModelProperty(value = "用户编号",required = true)
    @NotNull
    private Integer userId;

    @ApiModelProperty(value = "用户来源：|dr:dr|dr_admin:DR管理平台|user_center:用户中心|mr_beta:Mr.Beta|，默认从用户中心",required = true)
    private Source source = Source.user_center;

    @ApiModelProperty(value = "上级资源id")
    private Integer parentId;

    @ApiModelProperty("资源类型")
    private ResourceType type;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }
}
