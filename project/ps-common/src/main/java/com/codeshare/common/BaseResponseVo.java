package com.codeshare.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhaojun on 2018/7/3.
 **/

@ApiModel(description = "基础Vo")
public class BaseResponseVo<T> {

    @ApiModelProperty(value = "数据")
    private T data;

    /**
     * 返回消息
     */
    @ApiModelProperty(value = "响应信息")
    private String msg;

    /**
     * 代码
     */
    @ApiModelProperty(value = "响应码")
    private Integer code;

    /**
     * 是否成功
     */
    @ApiModelProperty(value = "成功标识")
    private boolean success;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
