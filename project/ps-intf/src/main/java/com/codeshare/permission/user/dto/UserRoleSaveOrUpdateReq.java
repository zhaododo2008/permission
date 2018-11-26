package com.codeshare.permission.user.dto;

import com.codeshare.permission.user.enums.Source;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author
 */
public class UserRoleSaveOrUpdateReq {

    /**
     * 用户编号
     */
    @NotNull(message = "用户编号不能为空")
    @ApiModelProperty(value = "用户编号",required = true)
    private Integer userId;


    /**
     * 角色列表，示例：2,3,5,7
     */
    @ApiModelProperty("角色列表，示例：2,3,5,7")
    private String roleIds;

    /**
     * 来源
     */
    @ApiModelProperty("用户来源")
    private Source source;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
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