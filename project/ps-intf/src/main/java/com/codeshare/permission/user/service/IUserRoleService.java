package com.codeshare.permission.user.service;

import com.codeshare.permission.user.dto.UserRoleQryReq;
import com.codeshare.permission.user.dto.UserRoleQueryRes;
import com.codeshare.permission.user.dto.UserRoleSaveOrUpdateReq;

import java.util.List;

/**
 * 用户角色权限接口
 * @author cjbi
 */
public interface IUserRoleService {

    /**
     * 查询用户角色权限
     * @param userRoleQuery
     * @return
     */
    List<UserRoleQueryRes> queryList(UserRoleQryReq userRoleQuery);

    /**
     * 查询单个资源
     * @param userRoleQuery
     * @return
     */
    UserRoleQueryRes queryOne(UserRoleQryReq userRoleQuery);

    /**
     * 根据userId删除角色
     * @param userId
     */
    void deleteByUserId(Integer userId);

    /**
     * 保存用户角色
     * @param userRoleSaveReq
     */
    void saveUserRole(UserRoleSaveOrUpdateReq userRoleSaveReq);

}
