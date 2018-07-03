package com.codeshare.permission.user.dto;

import com.codeshare.permission.common.BasePageRequest;
import com.codeshare.permission.user.enums.ResourceType;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author 
 */
public class ResourceQueryReq extends BasePageRequest {
    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("资源类型")
    private ResourceType type;

    @ApiModelProperty("路径")
    private String path;

    @ApiModelProperty("文件路径")
    private String filePath;

    @ApiModelProperty("父编号")
    private Integer parentId;

    @ApiModelProperty("父编号列表，示例：2,3,5,7")
    private String parentIds;

    @ApiModelProperty("权限字符串")
    private String permission;

    @ApiModelProperty("是否有效:|0.无效|1.有效")
    private Boolean available;

    @ApiModelProperty(hidden = true)
    private String icon;

    @ApiModelProperty(hidden = true)
    private Integer priority;

    @ApiModelProperty(hidden = true)
    private Boolean leaf;

    @ApiModelProperty(hidden = true)
    private Short delFlag;

    @ApiModelProperty(hidden = true)
    private Integer addUserId;

    @ApiModelProperty(hidden = true)
    private Integer updUserId;

    @ApiModelProperty(hidden = true)
    private Date createTime;

    @ApiModelProperty(hidden = true)
    private Date updateTime;
    private static final long serialVersionUID = 1L;

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

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
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