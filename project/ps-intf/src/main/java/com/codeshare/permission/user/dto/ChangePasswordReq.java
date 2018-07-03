package com.codeshare.permission.user.dto;

import com.codeshare.permission.user.enums.Source;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author cjbi
 */
@ApiModel("修改用户密码")
public class ChangePasswordReq {

    @ApiModelProperty("用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

    @ApiModelProperty("新密码")
    @NotBlank(message = "密码不能为空")
    @Length(min = 6,message = "密码长度不能低于6位")
    private String newPassword;

    @ApiModelProperty("用户来源：|dr:dr|dr_admin:DR管理平台|user_center:用户中心|mr_beta:Mr.Beta|")
    @NotNull(message = "用户来源不能为空")
    private Source source;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
