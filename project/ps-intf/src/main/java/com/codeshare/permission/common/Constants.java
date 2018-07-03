package com.codeshare.permission.common;

/**
 * 常量定义
 *
 * @author cjbi
 */
public class Constants {

    /**
     * 应用名
     */
    public static final String APP_NAME = "ps_web";

    /**
     * 校验通过
     */
    public static final String VERIFY = "ok";
    /**
     * 树的根节点
     */
    public static final int RESOURCE_ROOT_ID = 0;

    /**
     * 默认起始页
     */
    public static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 默认分页大小
     */
    public static final  int DEFAULT_PAGE_SIZE = 10;


    /**服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。*/
    public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
    /**有效期7天*/
    public static final long JWT_TTL = 7L*24L*60L*60L*1000L;

    public static final String TOKEN_HEADER = "Authorization";

    /**Swagger登陆时不存在token，使用默认的值*/
    public static final String DEFAULT_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI5OTk5OTk5OTkiLCJzdWIiOiJ7XCJpZFwiOiA5OTk5OTk5OTksXCJ1c2VySWRcIjogOTk5OTk5OTk5LFwibmFtZVwiOiBcIuW8gOWPkeS6uuWRmOa1i-ivlei0puWPt1wiIH0iLCJpYXQiOjE1Mjk0ODk2NTUsImp0aSI6Ijk5OTk5OTk5OSJ9.ktDwazqyHuk-gjnPuvV5i68S7xc2FVpL68kAAdijeUQ";

    public static final String DEFAULT_PASSWORD = "123456";

}
