package com.codeshare.permission.user.dto;

import com.codeshare.permission.common.BasePageRequest;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author cjbi
 */
public class RoleQueryReq extends BasePageRequest {
    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("资源编号列表，示例：2,4,5,7")
    private String resourceIds;

    @ApiModelProperty("是否有效,0无效,1有效")
    private Boolean available;

    private static final long serialVersionUID = 1L;

    /**
     * 1: 删除 0: 未删除
     */
    @ApiModelProperty(hidden = true)
    private Short delFlag;

    /**
     * 添加人
     */
    @ApiModelProperty(hidden = true)
    private Integer addUserId;

    /**
     * 更新人
     */
    @ApiModelProperty(hidden = true)
    private Integer updUserId;

    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(hidden = true)
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Short getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(Integer addUserId) {
        this.addUserId = addUserId;
    }

    public Integer getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(Integer updUserId) {
        this.updUserId = updUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}