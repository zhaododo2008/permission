package com.codeshare.permission.common;


import static com.codeshare.common.HttpResponseCode.SUCCESS;

/**
 * Created by zhaododo on 17/5/5.
 */
public class ApiResponse {

    private final static String SUCCESS_MSG="成功";

    public static ResponseVo<?> success(Object data){
        return getResponseVo(data, SUCCESS_MSG);
    }

    private static ResponseVo<?> getResponseVo(Object data, String successMsg) {
        ResponseVo responseVo = new ResponseVo<>();
        responseVo.setSuccess(true);
        responseVo.setCode(SUCCESS.intValue());
        responseVo.setData(data);
        responseVo.setMsg(successMsg);
        return  responseVo;
    }

    public static ResponseVo<?> success(String msg, Object data){
        return getResponseVo(data, msg);
    }

    public static ResponseVo<?> fail(int code, String msg){
        ResponseVo responseVo = new ResponseVo<>();
        responseVo.setSuccess(false);
        responseVo.setCode(code);
        responseVo.setMsg(msg);
        responseVo.setData(null);
        return  responseVo;
    }
}
