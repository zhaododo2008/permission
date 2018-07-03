package com.codeshare.permission.user.dto;

import com.codeshare.permission.user.enums.ResourceType;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author
 */
public class ResourceTreeRes {
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

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("优先级")
    private Integer priority;

    @ApiModelProperty("叶子节点:|0.否|1.是")
    private Boolean leaf;

    @ApiModelProperty("1: 删除 0: 未删除")
    private Short delFlag;

    @ApiModelProperty("添加人")
    private Integer addUserId;

    @ApiModelProperty("更新人")
    private Integer updUserId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    private List<ResourceTreeRes> children;

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

    public List<ResourceTreeRes> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceTreeRes> children) {
        this.children = children;
    }

    public String getCode() {
        return Optional.ofNullable(path).orElseGet(() -> "").replace("/", "");
    }

    @ApiModelProperty("资源类型名称")
    public String getTypeName() {
        return type.getInfo();
    }

}