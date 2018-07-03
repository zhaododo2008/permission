package com.codeshare.permission.user.impl;

import com.codeshare.common.CodeHelperUtil;
import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.common.PageResultSet;
import com.codeshare.permission.user.dto.RolePageQueryRes;
import com.codeshare.permission.user.dto.RoleQueryReq;
import com.codeshare.permission.user.service.IResourceService;
import com.codeshare.permission.user.service.IRoleFacade;
import com.codeshare.permission.user.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@Service
public class RoleFacadeImpl implements IRoleFacade {

    @Resource
    private IRoleService roleService;

    @Resource
    private IResourceService resourceService;

    @Override
    public PageResultSet<RolePageQueryRes> queryRoleListByPage(RoleQueryReq roleQueryReq) {
        PageResultSet<RolePageQueryRes> pageResultSet = new PageResultSet<>();
        pageResultSet.setTotal(roleService.queryTotal(roleQueryReq));
        roleService.queryList(roleQueryReq).forEach(roleQueryRes -> {
            RolePageQueryRes rolePageQueryRes = ModelMapperUtil.strictMap(roleQueryRes, RolePageQueryRes.class);
            Set<Integer> resourceIds = Arrays.asList(CodeHelperUtil.convertIdSplit(rolePageQueryRes.getResourceIds())).stream().collect(Collectors.toSet());
            rolePageQueryRes.setResourceList(resourceService.queryList(resourceIds));

            pageResultSet.addRow(rolePageQueryRes);
        });
        return pageResultSet;
    }
}
