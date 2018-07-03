package com.codeshare.permission.user.service;

import com.codeshare.permission.user.dto.UserRoleQueryReq;
import com.codeshare.permission.user.dto.UserRoleQueryRes;
import com.codeshare.permission.user.dto.UserRoleSaveReq;

import java.util.List;

/**
 * 用户角色权限接口
 * @author cjbi
 */
public interface UserRoleService {

    /**
     * 查询用户角色权限
     * @param userRoleQuery
     * @return
     */
    List<UserRoleQueryRes> queryList(UserRoleQueryReq userRoleQuery);

    UserRoleQueryRes queryOne(UserRoleQueryReq userRoleQuery);

    /**
     * 根据userId删除角色
     * @param userId
     */
    void deleteByUserId(Integer userId);

    /**
     * 保存用户角色
     * @param userRoleSaveReq
     */
    void saveUserRole(UserRoleSaveReq userRoleSaveReq);

}
