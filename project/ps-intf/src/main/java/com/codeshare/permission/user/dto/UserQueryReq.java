package com.codeshare.permission.user.dto;

import com.codeshare.permission.common.BasePageRequest;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import java.util.Date;

/**
 * @author
 */
public class UserQueryReq extends BasePageRequest {

    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty(hidden = true)
    private String password;

    @ApiModelProperty("邮箱")
    @Email(message = "请输入正确的邮箱")
    private String email;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("是否锁定:0:未锁定|1:锁定")
    private Boolean locked;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        if ("".equals(username)) {
            username = null;
        }
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
        if ("".equals(email)) {
            email = null;
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        if("".equals(phone)) {
            phone = null;
        }
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