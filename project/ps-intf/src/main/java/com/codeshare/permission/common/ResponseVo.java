package com.codeshare.permission.common;

import com.codeshare.common.BaseResponseVo;
import com.codeshare.common.ValidationResult;
import com.codeshare.permission.common.exception.BusinessException;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author cjbi
 */
public class ResponseVo<T> extends BaseResponseVo<T> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(hidden = true)
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static ResponseVo success() {
        return success(null);
    }

    public static <T> ResponseVo success(T data) {
        ResponseVo response = new ResponseVo();
        response.setSuccess(true);
        response.setCode(ResponseConstant.SUCCESS.intValue());
        response.setMsg(ResponseConstant.SUCCESS_MSG);
        response.setData(data);
        return response;
    }

    public static ResponseVo failure(BusinessException e) {
        return failure(e, e.getCode(), e.getMsg(), e.getMessage());
    }

    public static ResponseVo failure(Integer code, String msg) {
        return failure(null, code, msg, null);
    }

    public static ResponseVo failure(Integer code, String msg, String errorMsg) {
        return failure(null, code, msg, errorMsg);
    }

    public static ResponseVo failure(ValidationResult validationResult) {
        return failure(validationResult.getErrorMsg(), ResponseConstant.PARAM_ERROR, ResponseConstant.PARAM_ERROR_MSG, null);
    }

    public static <T> ResponseVo failure(T data, Integer code, String msg, String errorMsg) {
        ResponseVo response = new ResponseVo();
        response.setSuccess(false);
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        response.setErrorMsg(errorMsg);
        return response;
    }

}
