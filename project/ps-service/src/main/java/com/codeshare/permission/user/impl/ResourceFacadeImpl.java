package com.codeshare.permission.user.impl;

import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.user.dto.*;
import com.codeshare.permission.user.service.IResourceFacade;
import com.codeshare.permission.user.service.IResourceService;
import com.codeshare.permission.user.service.IUserRoleFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author cjbi
 */
@Service
public class ResourceFacadeImpl implements IResourceFacade {

    @Resource
    private IUserRoleFacade IUserRoleFacade;

    @Resource
    private IResourceService IResourceService;

    private List<ResourceTreeRes> getResourceTree(List<ResourceQueryRes> source, Integer pid) {
        List<ResourceTreeRes> target = getChildResourceByPid(source, pid);
        target.forEach(res -> res.setChildren(getResourceTree(source, res.getId())));
        return target;
    }

    private List<ResourceTreeRes> getChildResourceByPid(List<ResourceQueryRes> source, Integer parentId) {
        List<ResourceTreeRes> child = new ArrayList<>();
        source.forEach(res -> {
            if (parentId.equals(res.getParentId())) {
                child.add(ModelMapperUtil.strictMap(res, ResourceTreeRes.class));
            }
        });
        return child;
    }

    @Override
    public MenusRes queryMenus(ResourceTreeReq resourceTreeReq) {
        UserRoleQueryReq userRoleQueryReq = new UserRoleQueryReq();
        userRoleQueryReq.setUserId(resourceTreeReq.getUserId());
        userRoleQueryReq.setSource(resourceTreeReq.getSource());
        Set<String> permissions = IUserRoleFacade.queryPermissions(userRoleQueryReq);
        List<ResourceQueryRes> list = IResourceService.queryMenus(permissions);
        MenusRes menuTreeRes = new MenusRes(getResourceTree(list, resourceTreeReq.getSystemId()), list);
        return menuTreeRes;
    }
}
