package com.codeshare.permission.user.impl;

import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.common.Constants;
import com.codeshare.permission.user.dto.*;
import com.codeshare.permission.user.service.IResourceFacade;
import com.codeshare.permission.user.service.IResourceService;
import com.codeshare.permission.user.service.IUserRoleFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@Service
public class ResourceFacadeImpl implements IResourceFacade {

    @Resource
    private IUserRoleFacade userRoleFacade;

    @Resource
    private IResourceService resourceService;

    private List<ResourceTreeRes> getResourceTree(List<ResourceQueryRes> source, Integer pid) {
        List<ResourceTreeRes> target = getChildResourceByPid(source, pid);
        target.forEach(res -> res.setChildren(getResourceTree(source, res.getId())));
        return target;
    }

    private List<ResourceTreeRes> getChildResourceByPid(List<ResourceQueryRes> source, Integer parentId) {
        List<ResourceQueryRes> queryResList = source.stream()
                .filter(res -> parentId.equals(res.getParentId()))
                .collect(Collectors.toList());
        return ModelMapperUtil.strictMapList(queryResList, ResourceTreeRes.class);
    }

    @Override
    public MenusRes queryMenus(ResourceTreeReq resourceTreeReq) {
        UserRoleQryReq userRoleQueryReq = new UserRoleQryReq();
        userRoleQueryReq.setUserId(resourceTreeReq.getUserId());
        userRoleQueryReq.setSource(resourceTreeReq.getSource());
        Set<String> permissions = userRoleFacade.queryPermissions(userRoleQueryReq);
        List<ResourceQueryRes> list = resourceService.queryMenus(permissions);
        MenusRes menuTreeRes = new MenusRes(getResourceTree(list, resourceTreeReq.getSystemId()), list);
        return menuTreeRes;
    }

    @Override
    public List<ResourceTreeRes> queryResourceTree(ResourceQueryReq resourceQueryReq) {
        List<ResourceQueryRes> resourceQueryResList = resourceService.queryList(resourceQueryReq);
        return getResourceTree(resourceQueryResList, Constants.RESOURCE_ROOT_ID);
    }
}
