package com.codeshare.permission.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @author cjbi
 */
@ApiModel("用户分页返回")
public class UserPageQueryRes {

    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("是否锁定:0:未锁定|1:锁定")
    private Boolean locked;

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

    public List<RoleQueryRes> roleList;

    public List<RoleQueryRes> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleQueryRes> roleList) {
        this.roleList = roleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
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

    public String getUsername() {
        return username;
    }

    @ApiModelProperty("角色名称集")
    public String getRoleNames() {
        StringBuilder s = new StringBuilder();
        if (roleList != null && !roleList.isEmpty()) {
            for (RoleQueryRes res : roleList) {
                s.append(res.getName());
                s.append(",");
            }
            if (s.length() > 0) {
                s.deleteCharAt(s.length() - 1);
            }
        }
        return s.toString();
    }

    @ApiModelProperty("角色id集")
    public String getRoleIds() {
        StringBuilder s = new StringBuilder();
        if (roleList != null && !roleList.isEmpty()) {
            for (RoleQueryRes res : roleList) {
                s.append(res.getId());
                s.append(",");
            }
            if (s.length() > 0) {
                s.deleteCharAt(s.length() - 1);
            }
        }
        return s.toString();
    }

}


