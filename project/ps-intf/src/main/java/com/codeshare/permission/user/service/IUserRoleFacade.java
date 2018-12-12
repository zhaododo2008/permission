package com.codeshare.permission.user.service;


import com.codeshare.permission.common.PageResultSet;
import com.codeshare.permission.common.ReactPageResultSet;
import com.codeshare.permission.user.dto.*;
import com.codeshare.permission.user.enums.Source;

import java.util.Collection;
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
    List<RoleQueryRes> queryRoleList(UserRoleQryReq userRoleQuery);

    /**
     * 根据用户名角色等查找其权限
     * @param userRoleQuery
     * @return
     */
    Set<String>  queryPermissions(UserRoleQryReq userRoleQuery);

    /**
     * 查询dr客户端对应的权限
     * @param categoryQueryReq
     * @return
     */
    List<Category> queryCategoryList(CategoryQueryReq categoryQueryReq);

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
    void saveOrUpdateRoles(UserRoleSaveOrUpdateReq userRoleSaveReq);

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

    /**
     * 获取账号权限
     * @param userId
     * @param source
     * @param parentId
     * @return
     */
    Collection queryPermissions(Integer userId, Source source, Integer parentId);

}
