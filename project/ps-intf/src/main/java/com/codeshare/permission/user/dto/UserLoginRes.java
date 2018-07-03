package com.codeshare.permission.user.dto;


import java.util.Collection;

/**
 * 登陆返回对象
 * @author cjbi
 */
public class UserLoginRes {

    private IUser user;

    private String token;

    private Collection permissions;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    public Collection getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection permissions) {
        this.permissions = permissions;
    }
}
