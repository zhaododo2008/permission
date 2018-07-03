package com.codeshare.permission.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author cjbi
 */
@ApiModel("用户信息")
public class DesignerQueryRes {
    /**
     * 设计师id
     */
    @ApiModelProperty("设计师id")
    public Integer id;
    @ApiModelProperty("用户id")
    public Integer userId;
    @ApiModelProperty("设计师名称")
    public String name;
    @ApiModelProperty("设计案例")
    private String designCase;
    @ApiModelProperty("公司")
    public String company;
    @ApiModelProperty("补充")
    private String extra;
    @ApiModelProperty("手机号")
    private String mobile;

    public List<RoleQueryRes> roleList;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignCase() {
        return designCase;
    }

    public void setDesignCase(String designCase) {
        this.designCase = designCase;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
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
