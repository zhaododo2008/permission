package com.codeshare.permission.user.dto;


import com.codeshare.permission.common.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author cjbi
 */
@ApiModel("用户分页查询")
public class DesignerQueryReq extends BasePageRequest {
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("设计师名称")
    private String nickName;
    @ApiModelProperty(hidden = true)
    private String roleCode = "2";

    public String getMobile() {
        if ("".equals(mobile)) {
           this.mobile = null;
        }
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        if ("".equals(nickName)) {
            this.nickName = null;
        }
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
