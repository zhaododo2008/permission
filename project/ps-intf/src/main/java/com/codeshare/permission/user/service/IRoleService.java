package com.codeshare.permission.user.service;

import com.codeshare.permission.common.PageResultSet;
import com.codeshare.permission.user.dto.RoleQueryReq;
import com.codeshare.permission.user.dto.RoleQueryRes;
import com.codeshare.permission.user.dto.RoleSaveReq;
import com.codeshare.permission.user.dto.RoleUpdateReq;

import java.util.List;
import java.util.Set;

/**
 * 角色接口
 * @author cjbi
 */
public interface IRoleService {

    /**
     * 根据角色编号得到角色标识符列表
     * @param roleIds
     * @return
     */
    List<RoleQueryRes> queryRoleList(Integer... roleIds);

    /**
     * 根据角色编号得到资源列表
     * @param roleIds
     * @return
     */
    Set<Integer> queryResources(Integer... roleIds);

    /**
     * 分页查询列表
     * @param roleQueryReq
     * @return
     */
    PageResultSet<RoleQueryRes> queryListByPage(RoleQueryReq roleQueryReq);

    List<RoleQueryRes> queryList(RoleQueryReq roleQueryReq);

    long queryTotal(RoleQueryReq roleQueryReq);

    List<RoleQueryRes> queryAll();

    /**
     * 保存角色
     * @param roleSaveReq
     */
    void saveRole(RoleSaveReq roleSaveReq);

    /**
     * 更新角色
     * @param roleUpdateReq
     */
    void updateRole(RoleUpdateReq roleUpdateReq);

    void deleteRole(Integer id);

}
