package com.codeshare.permission.common;

import com.codeshare.common.HttpResponseCode;

/**
 * Created by zhaojun on 2018/7/3.
 **/

public class ResponseConstant extends HttpResponseCode {

    public static final Integer DB_INSERT_ERROR = 101;
    public static final String DB_INSERT_ERROR_MSG = "数据保存失败";

    public static final Integer DB_UPDATE_ERROR = 102;
    public static final String DB_UPDATE_ERROR_MSG = "数据更新失败";

    public static final Integer DB_DELETE_ERROR = 103;
    public static final String DB_DELETE_ERROR_MSG = "数据删除失败";

    public static final Integer DB_SELECT_ERROR = 104;
    public static final String DB_SELECT_ERROR_MSG = "数据查询失败";

    public static final Integer DB_DUPLICATE_KEY = 105;
    public static final String DB_DUPLICATE_KEY_MSG = "主键冲突";

    public static final Integer OPERATE_TIMEOUT = 106;
    public static final String OPERATE_TIMEOUT_MSG = "操作已超时";

    public static final Integer RECORD_NOT_EXIST = 107;
    public static final String RECORD_NOT_EXIST_MSG = "记录不存在";

    public static final Integer RECORD_STATE_ERROR = 108;
    public static final String RECORD_STATE_ERROR_MSG = "记录状态错误";

    public static final Integer RECORD_EXIST = 109;
    public static final String RECORD_EXIST_MSG = "记录已存在";

    public static final Integer REMOTE_SERVICE_ERROR = 110;
    public static final String REMOTE_SERVICE_ERROR_MSG = "远程服务调用失败";

    public static final Integer JWT_ERROR = 111;
    public static final String JWT_ERROR_MSG = "登陆失败，请重新登陆";

    public static final Integer JWT_EXPIRED_ERROR = 112;
    public static final String JWT_EXPIRED_ERROR_MSG = "登陆过期，请重新登陆";

    public static final Integer TOKEN_LOST_ERROR = 113;
    public static final String TOKEN_LOST_ERROR_MSG = "Token 缺失";

    public static final Integer FAILED_DEL_OWN = 114;
    public static final String FAILED_DEL_OWN_MSG = "不能删除自己";

    public static final Integer PASSWORD_VERIFY_ERROR = 115;
    public static final String PASSWORD_VERIFY_ERROR_MSG = "用户名或密码错误，请重新输入";

    public static final Integer PHONE_VERIFY_ERROR = 116;
    public static final String PHONE_VERIFY_ERROR_MSG = "手机号码错误";

    public static final Integer ACCOUNT_NOT_EXIST = 117;
    public static final String ACCOUNT_NOT_EXIST_MSG = "账号不存在";

    public static final Integer VERIFY_CODE_ERROR = 118;
    public static final String VERIFY_CODE_ERROR_MSG = "验证码有误，请重试";

    public static final Integer VERIFY_CODE_TIME_OUT = 119;
    public static final String VERIFY_CODE_TIME_OUT_MSG = "验证码超时";

    public static final Integer HTTP_MESSAGE_ERROR = 120;

    public static final String HTTP_MESSAGE_ERROR_MSG = "HTTP消息转换错误，请检查请求参数";

    //此处定义业务异常码，定义规则从10x开始，避免和系统异常冲突，例如，101 模型审核通过，不能再次审核...

    public static final Integer SOLUTION_NAME_EXIST_ERROR = 121;

    public static final String NORMAL_SOLUTION_NAME_EXIST_ERROR_NSG = "同楼盘同户型，请使用不同方案名称！";
    public static final String DNA_SOLUTION_NAME_EXIST_ERROR_NSG = "与已有DNA重名，请重新命名！";

    public static final Integer DESIGNER_INFO_NOT_EXIST = 122;

    public static final String DESIGNER_INFO_NOT_EXIST_MSG = "此账号无设计师权限，请联系管理员";

    public static final Integer PARAM_ERROR = -1;
    public static final String PARAM_ERROR_MSG = "参数错误";

    public static final String SUCCESS_MSG = "成功";
    public static final String FAILED_MSG = "失败";
}
