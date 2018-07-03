package com.codeshare.permission.user.enums;

/**
 * 数据来源
 * @author cjbi
 */
public  enum Source {

    dr_admin("DR管理平台"),
    user_center("用户中心"),
    mr_beta("Mr.Beta");

    private String info;

    public String getInfo() {
        return info;
    }

    private Source(String info) {
        this.info = info;
    }
}
