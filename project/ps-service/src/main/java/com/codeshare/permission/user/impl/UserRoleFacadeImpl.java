package com.codeshare.permission.user.impl;

import com.codeshare.common.CodeHelperUtil;
import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.common.PageResultSet;
import com.codeshare.permission.user.dto.*;
import com.codeshare.permission.user.enums.Source;
import com.codeshare.permission.user.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 用户角色组合服务
 *
 * @author cjbi
 */
@Service
public class UserRoleFacadeImpl implements IUserRoleFacade {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private IRoleService roleService;

    @Resource
    private IResourceService resourceService;

    @Resource
    private UserService userService;

    @Override
    public List<RoleQueryRes> queryRoleList(UserRoleQueryReq userRoleQuery) {
        UserRoleQueryRes queryResult = userRoleService.queryOne(userRoleQuery);
        if (queryResult == null) {
            return Collections.EMPTY_LIST;
        }
        List<RoleQueryRes> roleQueryResList = roleService.queryRoleList(CodeHelperUtil.convertIdSplit(queryResult.getRoleIds()));
        if (roleQueryResList == null) {
            return Collections.EMPTY_LIST;
        }
        return ModelMapperUtil.strictMapList(roleQueryResList, RoleQueryRes.class);
    }

    @Override
    public Set<String> queryPermissions(UserRoleQueryReq userRoleQuery) {
        UserRoleQueryRes queryResult = userRoleService.queryOne(userRoleQuery);
        if (queryResult == null) {
            return Collections.EMPTY_SET;
        }
        Set<Integer> roleIdSet = new HashSet<>();
        Arrays.stream(queryResult.getRoleIds().split(",")).forEach(id -> {
            roleIdSet.add(Integer.valueOf(id));

        });
        Set<Integer> resourceIdSet = roleService.queryResources(roleIdSet.toArray(new Integer[0]));
        List<ResourceQueryRes> resourceQueryResList = resourceService.queryList(resourceIdSet);
        if (resourceQueryResList == null) {
            return Collections.EMPTY_SET;
        }
        return resourceQueryResList.stream()
                .filter(resourceQueryRes -> StringUtils.isNotBlank(resourceQueryRes.getPermission()))
                .map(ResourceQueryRes::getPermission)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> queryPermissions(PermissionsQueryReq permissionsQueryReq) {
        UserRoleQueryReq userRoleQuery = new UserRoleQueryReq();
        userRoleQuery.setUserId(permissionsQueryReq.getUserId());
        userRoleQuery.setSource(permissionsQueryReq.getSource());
        UserRoleQueryRes queryResult = userRoleService.queryOne(userRoleQuery);
        if (queryResult == null) {
            return Collections.EMPTY_SET;
        }
        Set<Integer> roleIdSet = new HashSet<>();
        Arrays.stream(queryResult.getRoleIds().split(",")).forEach(id -> {
            roleIdSet.add(Integer.valueOf(id));
        });
        Set<Integer> resourceIdSet = roleService.queryResources(roleIdSet.toArray(new Integer[0]));
        List<ResourceQueryRes> resourceQueryResList = filterResource(resourceService.queryList(resourceIdSet), permissionsQueryReq);
        return resourceQueryResList.stream()
                .filter(resourceQueryRes -> StringUtils.isNotBlank(resourceQueryRes.getPermission()))
                .map(ResourceQueryRes::getPermission)
                .collect(Collectors.toSet());
    }

    @Override
    public List<Category> queryDrClientPermissions(PermissionsQueryReq permissionsQueryReq) {
        UserRoleQueryReq userRoleQueryReq = new UserRoleQueryReq();
        userRoleQueryReq.setUserId(permissionsQueryReq.getUserId());
        userRoleQueryReq.setSource(Source.user_center);
        UserRoleQueryRes userRoleQueryRes = Optional.ofNullable(userRoleService.queryOne(userRoleQueryReq)).orElseGet(() -> new UserRoleQueryRes());
        Integer[] roleIds = CodeHelperUtil.convertIdSplit(userRoleQueryRes.getRoleIds());
        Set<Integer> resources = roleService.queryResources(roleIds);
        List<Category> categoryList = new ArrayList<>();
        ResourceQueryReq resourceQueryReq = new ResourceQueryReq();
        resourceQueryReq.setParentId(permissionsQueryReq.getParentId());
        Optional.ofNullable(resourceService.queryList(resourceQueryReq)).ifPresent(list -> list.forEach(resourceQueryRes -> {
            Category category = new Category();
            category.setCategory(resourceQueryRes.getPermission());
            category.setVisibility(resources.contains(resourceQueryRes.getId()));
            resourceQueryReq.setParentId(resourceQueryRes.getId());
            List<Authority> authorityList = new ArrayList<>();
            Optional.ofNullable(resourceService.queryList(resourceQueryReq)).ifPresent(childList -> childList.forEach(childResourceQueryRes -> {
                Authority authority = new Authority();
                authority.setAuthorityId(childResourceQueryRes.getPermission());
                authority.setVisibility(resources.contains(childResourceQueryRes.getId()));
                authorityList.add(authority);
            }));
            category.setChild(authorityList);
            categoryList.add(category);
        }));
        return categoryList;
    }


    private List<ResourceQueryRes> filterResource(List<ResourceQueryRes> resourceQueryResList, PermissionsQueryReq permissionsQueryReq) {
        if (resourceQueryResList == null) {
            return Collections.EMPTY_LIST;
        }
        if (permissionsQueryReq.getParentId() != null) {
            resourceQueryResList = resourceQueryResList
                    .stream()
                    .filter(resourceQueryRes -> permissionsQueryReq.getParentId().equals(resourceQueryRes.getParentId()))
                    .collect(Collectors.toList());
        }
        if (permissionsQueryReq.getType() != null) {
            resourceQueryResList = resourceQueryResList
                    .stream()
                    .filter(resourceQueryRes -> permissionsQueryReq.getType().equals(resourceQueryRes.getParentId()))
                    .collect(Collectors.toList());
        }
        return resourceQueryResList;
    }

    @Override
    public PageResultSet<UserPageQueryRes> queryUserListByPage(UserQueryReq userQueryReq) {
        PageResultSet<UserPageQueryRes> pageResultSet = new PageResultSet();
        pageResultSet.setTotal(userService.queryTotal(userQueryReq));
        userService.queryList(userQueryReq).forEach(userQueryRes -> {
            UserPageQueryRes userPageQueryRes = ModelMapperUtil.strictMap(userQueryRes, UserPageQueryRes.class);

            UserRoleQueryReq userRoleQueryReq = new UserRoleQueryReq();
            userRoleQueryReq.setUserId(userQueryRes.getUserId());
            userRoleQueryReq.setSource(Source.dr_admin);
            List<RoleQueryRes> roleList = queryRoleList(userRoleQueryReq);
            userPageQueryRes.setRoleList(roleList);

            pageResultSet.addRow(userPageQueryRes);
        });

        return pageResultSet;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRoles(UserRoleSaveReq userRoleSaveReq) {
        //先删后增
        userRoleService.deleteByUserId(userRoleSaveReq.getUserId());
        userRoleService.saveUserRole(userRoleSaveReq);
    }

    @Override
    public void syncUserRole(){

    }

    /**
     * 获取设计师用户数量
     *
     * @return
     */
    private int getDesignerTotal(){
        return 0;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(UserSaveReq userSaveReq) {
        //保存系统用户
        Integer userId = userService.saveUser(userSaveReq);
        //更新用户权限
        UserRoleSaveReq userRoleSaveReq = new UserRoleSaveReq();
        userRoleSaveReq.setUserId(userId);
        userRoleSaveReq.setRoleIds(userSaveReq.getRoleIds());
        userRoleSaveReq.setSource(Source.dr_admin);
        updateRoles(userRoleSaveReq);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserUpdateReq userUpdateReq) {
        //保存系统用户
        userService.updateUser(userUpdateReq);
        //更新用户权限
        UserRoleSaveReq userRoleSaveReq = new UserRoleSaveReq();
        userRoleSaveReq.setUserId(userUpdateReq.getId());
        userRoleSaveReq.setRoleIds(userUpdateReq.getRoleIds());
        userRoleSaveReq.setSource(Source.dr_admin);
        updateRoles(userRoleSaveReq);
    }

}
