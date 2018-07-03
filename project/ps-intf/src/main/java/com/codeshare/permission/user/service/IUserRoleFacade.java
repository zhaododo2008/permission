package com.codeshare.permission.user.service;


import com.codeshare.permission.common.PageResultSet;
import com.codeshare.permission.user.dto.*;

import java.util.List;
import java.util.Set;

/**
 * 用户角色组合服务接口
 * @author cjbi
 */
public interface IUserRoleFacade {

    /**
     * 根据用户查找其角色
     * @param userRoleQuery
     * @return
     */
    List<RoleQueryRes> queryRoleList(UserRoleQueryReq userRoleQuery);

    /**
     * 根据用户名角色等查找其权限
     * @param userRoleQuery
     * @return
     */
    Set<String>  queryPermissions(UserRoleQueryReq userRoleQuery);

    /**
     * 根据用户信息查询其权限
     * @param permissionsQueryReq
     * @return
     */
    Set<String> queryPermissions(PermissionsQueryReq permissionsQueryReq);

    /**
     * 查询dr客户端权限
     * @param permissionsQueryReq
     * @return
     */
    List<Category> queryDrClientPermissions(PermissionsQueryReq permissionsQueryReq);

    /**
     * 分页查询系统用户列表
     * @param userQueryReq
     * @return
     */
    PageResultSet<UserPageQueryRes> queryUserListByPage(UserQueryReq userQueryReq);

    /**
     * 更新角色
     * @param userRoleSaveReq
     */
    void updateRoles(UserRoleSaveReq userRoleSaveReq);

    /**
     * 同步设计师用户的角色
     */
    void syncUserRole();

    /**
     * 保存系统用户
     * @param userSaveReq
     */
    void saveUser(UserSaveReq userSaveReq);

    /**
     * 更新系统用户
     * @param userUpdateReq
     */
    void updateUser(UserUpdateReq userUpdateReq);

}
