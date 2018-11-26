package com.codeshare.permission.user.impl;

import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.common.Constants;
import com.codeshare.permission.common.ResponseConstant;
import com.codeshare.permission.common.authz.permission.WildcardPermission;
import com.codeshare.permission.common.exception.BusinessException;
import com.codeshare.permission.common.util.CollectionUtils;
import com.codeshare.permission.user.dao.ResourceDao;
import com.codeshare.permission.user.dto.ResourceQueryReq;
import com.codeshare.permission.user.dto.ResourceQueryRes;
import com.codeshare.permission.user.dto.ResourceSaveReq;
import com.codeshare.permission.user.dto.ResourceUpdateReq;
import com.codeshare.permission.user.enums.ResourceType;
import com.codeshare.permission.user.po.Resource;
import com.codeshare.permission.user.service.IResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 资源服务
 *
 * @author cjbi
 */
@Service
public class ResourceServiceImpl implements IResourceService {

    @javax.annotation.Resource
    private ResourceDao resourceDao;

    @Override
    public List<ResourceQueryRes> queryList(ResourceQueryReq resourceQueryReq) {
        resourceQueryReq.setOrderBy("priority");
        List<Resource> resourceList = resourceDao.selectList(resourceQueryReq);
        if (resourceList == null) {
            return Collections.EMPTY_LIST;
        }
        return ModelMapperUtil.strictMapList(resourceList, ResourceQueryRes.class);
    }

    @Override
    public ResourceQueryRes queryResourceById(Integer id) {
        Resource resource = resourceDao.selectByPrimaryKey(id);
        if (resource == null) {
            return null;
        }
        return ModelMapperUtil.strictMap(resource, ResourceQueryRes.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveResource(ResourceSaveReq resourceSaveReq) {
        Resource resource = ModelMapperUtil.strictMap(resourceSaveReq, Resource.class);
        Resource parent = resourceDao.selectByPrimaryKey(resourceSaveReq.getParentId());
        resource.setParentIds(parent.makeSelfAsParentIds());
        int rows = resourceDao.insertSelective(resource);
        if (rows == 0) {
            throw new BusinessException(ResponseConstant.DB_INSERT_ERROR, ResponseConstant.DB_INSERT_ERROR_MSG);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateResource(ResourceUpdateReq resourceUpdateReq) {
        Resource resource = ModelMapperUtil.strictMap(resourceUpdateReq, Resource.class);
        int rows = resourceDao.updateByPrimaryKeySelective(resource);
        if (rows == 0) {
            throw new BusinessException(ResponseConstant.DB_UPDATE_ERROR, ResponseConstant.DB_UPDATE_ERROR_MSG);
        }
    }

    @Override
    public void deleteResource(Integer id) {
        int rows = resourceDao.deleteByPrimaryKey(id);
        if (rows == 0) {
            throw new BusinessException(ResponseConstant.DB_DELETE_ERROR, ResponseConstant.DB_DELETE_ERROR_MSG);
        }
    }

    @Override
    public List<ResourceQueryRes> queryList(Set<Integer> resourceIds) {
        if (CollectionUtils.isEmpty(resourceIds)) {
            return Collections.EMPTY_LIST;
        }
        List<Resource> resourceList = Optional.ofNullable(resourceDao.selectByPrimaryKeys(resourceIds))
                .orElseGet(() -> Collections.EMPTY_LIST);
        return ModelMapperUtil.strictMapList(resourceList, ResourceQueryRes.class);
    }

    @Override
    public List<ResourceQueryRes> queryListByParentIds(String parentIds) {
        List<Resource> resourceList = Optional
                .ofNullable(resourceDao.selectByParentIdsLike(parentIds + "%"))
                .orElseGet(() -> Collections.EMPTY_LIST);
        return ModelMapperUtil.strictMapList(resourceList, ResourceQueryRes.class);
    }

    @Override
    public List<ResourceQueryRes> queryMenus(Set<String> permissions) {
        ResourceQueryReq resourceQueryReq = new ResourceQueryReq();
        resourceQueryReq.setOrderBy("priority");
        List<Resource> allResources = resourceDao.selectList(resourceQueryReq);
        List<ResourceQueryRes> menus = new ArrayList<>();
        for (Resource resource : allResources) {
            if (Constants.RESOURCE_ROOT_ID == resource.getParentId()) {
                continue;
            }
            if (resource.getType() != ResourceType.MENU) {
                continue;
            }
            if (!hasPermission(permissions, resource)) {
                continue;
            }
            menus.add(ModelMapperUtil.strictMap(resource, ResourceQueryRes.class));
        }
        return menus;
    }

    private boolean hasPermission(Set<String> permissions, Resource resource) {
        if (StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for (String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if (p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }


}
