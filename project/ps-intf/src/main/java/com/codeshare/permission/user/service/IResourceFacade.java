package com.codeshare.permission.user.service;

import com.codeshare.permission.user.dto.MenusRes;
import com.codeshare.permission.user.dto.ResourceTreeReq;

/**
 *
 * @author cjbi
 */
public interface IResourceFacade {

    /**
     * 查询菜单树
     * @param resourceTreeReq
     * @return
     */
    MenusRes queryMenus(ResourceTreeReq resourceTreeReq);

}
