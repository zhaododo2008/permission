package com.codeshare.permission.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @author 
 */
@ApiModel("用户保存")
public class UserSaveReq {

    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty("用户名")
    @NotBlank
    private String username;

    @ApiModelProperty(hidden = true)
    private String password;

    @ApiModelProperty("邮箱")
    @NotBlank
    @Email(message = "请输入正确的邮箱")
    private String email;

    @ApiModelProperty("手机号")
    @NotBlank
    private String phone;

    @ApiModelProperty("是否锁定:0:未锁定|1:锁定")
    private Boolean locked = Boolean.TRUE;

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

    /**
     * 角色列表，示例：2,3,5,7
     */
    @ApiModelProperty("角色列表，示例：2,3,5,7")
    private String roleIds;

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
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
}