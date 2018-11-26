package com.codeshare.permission.user.enums;

/**
 * 资源类型
 * @author cjbi
 */

public enum ResourceType {

    TEXT("文本"),
    GROUP("组"),
    MODULE("模块"),
    MENU("菜单"),
    BUTTON("按钮"),
    PANEL("面板"),
    OTHER("其他");

    private String info;

    private ResourceType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
