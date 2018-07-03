package com.codeshare.permission.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 更新角色
 * @author cjbi
 */
@ApiModel("角色")
public class RoleUpdateReq {

    @ApiModelProperty("编号")
    @NotNull(message = "编号不能为空")
    private Integer id;


    @ApiModelProperty("角色名称")
    @NotBlank(message = "角色不能为空")
    private String name;

    @ApiModelProperty("描述")
    @NotBlank(message = "角色描述不能为空")
    private String description;

    @ApiModelProperty("资源编号列表，示例：2,4,5,7")
    private String resourceIds;

    @ApiModelProperty("是否有效,0无效,1有效")
    private Boolean available;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
