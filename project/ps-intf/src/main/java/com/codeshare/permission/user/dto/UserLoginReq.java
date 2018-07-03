package com.codeshare.permission.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户登陆接口
 *
 * @author cjbi
 */
@ApiModel("用户登陆")
public class UserLoginReq {

    @ApiModelProperty("输入用户名/邮箱/手机号")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty("输入密码")
    @NotBlank(message = "密码不能为空")
    private String password;

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
}
