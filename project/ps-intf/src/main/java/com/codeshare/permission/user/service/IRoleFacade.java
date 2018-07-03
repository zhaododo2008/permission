package com.codeshare.permission.user.service;

import com.codeshare.permission.common.PageResultSet;
import com.codeshare.permission.user.dto.RolePageQueryRes;
import com.codeshare.permission.user.dto.RoleQueryReq;

/**
 *
 * @author cjbi
 */
public interface IRoleFacade {

    /**
     * 查询角色信息
     * @param roleQueryReq
     * @return
     */
    PageResultSet<RolePageQueryRes> queryRoleListByPage(RoleQueryReq roleQueryReq);

}
