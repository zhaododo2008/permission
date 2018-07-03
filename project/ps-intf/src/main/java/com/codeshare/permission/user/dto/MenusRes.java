package com.codeshare.permission.user.dto;

import java.util.List;

/**
 * 查询菜单树和页面路由返回对象
 * @author cjbi
 */
public class MenusRes {

    public List<ResourceTreeRes> menuTree;

    public List<ResourceQueryRes> menuList;

    public MenusRes() {
    }

    public MenusRes(List<ResourceTreeRes> menuTree, List<ResourceQueryRes> menuList) {
        this.menuTree = menuTree;
        this.menuList = menuList;
    }

    public List<ResourceTreeRes> getMenuTree() {
        return menuTree;
    }

    public void setMenuTree(List<ResourceTreeRes> menuTree) {
        this.menuTree = menuTree;
    }

    public List<ResourceQueryRes> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<ResourceQueryRes> menuList) {
        this.menuList = menuList;
    }
}
