package com.codeshare.permission.user.dto;

import com.codeshare.permission.common.BasePageRequest;
import com.codeshare.permission.user.enums.Source;

import java.util.Date;

/**
 * @author
 */
public class UserRoleQueryReq extends BasePageRequest {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 角色列表，示例：2,3,5,7
     */
    private String roleIds;

    /**
     * 来源
     */
    private Source source;

    /**
     * 1: 删除 0: 未删除
     */
    private Short delFlag;

    /**
     * 添加人
     */
    private Integer addUserId;

    /**
     * 更新人
     */
    private Integer updUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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