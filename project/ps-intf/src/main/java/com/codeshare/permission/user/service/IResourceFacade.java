package com.codeshare.permission.user.service;

import com.codeshare.permission.user.dto.MenusRes;
import com.codeshare.permission.user.dto.ResourceQueryReq;
import com.codeshare.permission.user.dto.ResourceTreeReq;
import com.codeshare.permission.user.dto.ResourceTreeRes;

import java.util.List;

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
    MenusRes  queryMenus(ResourceTreeReq resourceTreeReq);

    /**
     * 查询资源树
     * @param resourceQueryReq
     * @return
     */
    List<ResourceTreeRes> queryResourceTree(ResourceQueryReq resourceQueryReq);

}
