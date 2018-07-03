package com.codeshare.permission.common;

import com.codeshare.common.ValidationResult;
import com.codeshare.permission.common.exception.BusinessException;

/**
 * @author cjbi
 */
public class ResponseVo<T> extends com.codeshare.common.ResponseVo<T> {

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
        return failure(null, e.getCode(), e.getMsg());
    }

    public static ResponseVo failure(Integer code, String msg) {
        return failure(null, code, msg);
    }

    public static ResponseVo failure(ValidationResult validationResult) {
        return failure(validationResult.getErrorMsg(), ResponseConstant.PARAM_ERROR,validationResult.getErrorMsgJson());
    }

    public static <T> ResponseVo failure(T data, Integer code, String msg) {
        ResponseVo response = new ResponseVo();
        response.setSuccess(false);
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

}
