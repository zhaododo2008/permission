package com.codeshare.permission.user.enums;

/**
 * 数据来源
 * @author cjbi
 */
public  enum Source {

    UNKNOWN("未知"),
    DR_ADMIN("DR管理平台"),
    USER_CENTER("用户中心"),
    MR_BETA("MR.BETA");

    private String info;

    public String getInfo() {
        return info;
    }

    private Source(String info) {
        this.info = info;
    }
}
