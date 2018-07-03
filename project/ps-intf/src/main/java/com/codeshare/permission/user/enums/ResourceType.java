package com.codeshare.permission.user.enums;

/**
 * 资源类型
 * @author cjbi
 */

public enum ResourceType {

    text("文本"),
    group("组"),
    module("模块"),
    menu("菜单"),
    button("按钮"),
    panel("面板"),
    other("其他");

    private String info;

    private ResourceType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
