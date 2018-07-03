package com.codeshare.common;

/**
 * Created by zhaojun on 2018/7/3.
 **/

public class HttpResponseCode {

    public static final Long SUCCESS = 0X000001L;
    public static final Long FAILED = 0X000002L;
    public static final Long Data_EXISTS = 0X000003L;

    //account related
    public static final Long TOKEN_EXPIRE = 0X100001L;
    public static final Long USER_NOT_EXISTS = 0X100002L;
    public static final Long USER_NOT_LOGIN = 0X100003L;

    //product related
    public static final Long PRODUCT_NOT_EXISTS = 0X300001L;

    //National marketing
    public static final Long MOBILE_NOT_EXISTS = 0X400001L;
    //    public static final Long ILLEGAL_USER = 0X400002L;
    //params
    public static final Long PARAMS_NOT_EXISTS = 0X000004L;

    //绑定信息
    public static final Long BINGDING_SUCCESS = 0X500000L;
    public static final Long INVITE_NOT_AIJIA_USER = 0X500001L;
    public static final Long INVITED_NOT_AIJIA_USER = 0X500002L;
    public static final Long INVITE_IS_AIJIA_USER = 0X500003L;
    public static final Long INVITED_IS_AIJIA_USER = 0X500004L;
    public static final Long REPEATER_BINGDING = 0X500005L;

    //未登录或该账号在其他地方登录
    public static final Long ADMIN_ILLEGAL = 0X000003L;
}
