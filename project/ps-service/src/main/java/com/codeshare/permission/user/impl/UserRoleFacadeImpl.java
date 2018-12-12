package com.codeshare.permission.user.impl;

import com.codeshare.common.CodeHelperUtil;
import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.common.PageResultSet;
import com.codeshare.permission.common.ReactPageResultSet;
import com.codeshare.permission.proxy.UserProxy;
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
    private IUserRoleService userRoleService;

    @Resource
    private IRoleService roleService;

    @Resource
    private IResourceService resourceService;

    @Resource
    private UserProxy userProxy;

    @Resource
    private IUserService userService;

    @Override
    public List<RoleQueryRes> queryRoleList(UserRoleQryReq userRoleQuery) {
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
    public Set<String> queryPermissions(UserRoleQryReq userRoleQuery) {
        UserRoleQueryRes queryResult = userRoleService.queryOne(userRoleQuery);
        if (queryResult == null) {
            return Collections.EMPTY_SET;
        }
        Set<Integer> roleIdSet = new HashSet<>();
        Arrays.stream(queryResult.getRoleIds().split(",")).forEach(id -> roleIdSet.add(Integer.valueOf(id)));
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
    public List<Category> queryCategoryList(CategoryQueryReq categoryQueryReq) {
        //查询设计师拥有的资源
        Set<Integer> userResources = queryUserResource(categoryQueryReq.getUserId(), Source.USER_CENTER);
        ResourceQueryReq resourceQueryReq = new ResourceQueryReq();
        resourceQueryReq.setParentId(categoryQueryReq.getParentId());
        //构建category和对应的authority返回给客户端
        return buildCategoryList(resourceQueryReq, userResources);
    }

    private Set<Integer> queryUserResource(Integer userId, Source source) {
        UserRoleQryReq userRoleQueryReq = new UserRoleQryReq();
        userRoleQueryReq.setUserId(userId);
        userRoleQueryReq.setSource(source);
        UserRoleQueryRes userRoleQueryRes = Optional.ofNullable(userRoleService.queryOne(userRoleQueryReq)).orElseGet(() -> new UserRoleQueryRes());
        Integer[] roleIds = CodeHelperUtil.convertIdSplit(userRoleQueryRes.getRoleIds());
        return roleService.queryResources(roleIds);
    }


    private List<Category> buildCategoryList(ResourceQueryReq resourceQueryReq, Set<Integer> userResources) {
        //查询所在的资源
        String parentIds = Optional
                .ofNullable(resourceService.queryResourceById(resourceQueryReq.getParentId()))
                .map(ResourceQueryRes::getParentIds)
                .orElse(null);
        if (parentIds == null) {
            return Collections.EMPTY_LIST;
        }
        parentIds = parentIds + resourceQueryReq.getParentId() + "/";
        List<ResourceQueryRes> resList = resourceService.queryListByParentIds(parentIds);
        List<Category> categoryList = new ArrayList<>();
        resList.stream()
                .filter(res -> res.getParentId().equals(resourceQueryReq.getParentId()))
                .forEach(res -> {
                    Category category = new Category();
                    category.setCategory(res.getPermission());
                    category.setVisibility(userResources.contains(res.getId()));
                    List<Authority> authorityList = new ArrayList<>();
                    resList.stream()
                            .filter(res2 -> res2.getParentId().equals(res.getId()))
                            .forEach(res2 -> {
                                Authority authority = new Authority();
                                authority.setAuthorityId(res2.getPermission());
                                authority.setVisibility(userResources.contains(res2.getId()));
                                authorityList.add(authority);
                            });
                    category.setChild(authorityList);
                    categoryList.add(category);
                });
        return categoryList;
    }


    @Override
    public PageResultSet<UserPageQueryRes> queryUserListByPage(UserQueryReq userQueryReq) {
        PageResultSet<UserPageQueryRes> pageResultSet = new PageResultSet();

        initQueryReq(userQueryReq);

        long total = userService.queryTotal(userQueryReq);
        pageResultSet.setTotal(total);
        userService.queryList(userQueryReq).forEach(userQueryRes -> {
            UserPageQueryRes userPageQueryRes = ModelMapperUtil.strictMap(userQueryRes, UserPageQueryRes.class);
            UserRoleQryReq userRoleQueryReq = new UserRoleQryReq();
            userRoleQueryReq.setUserId(userQueryRes.getUserId());
            userRoleQueryReq.setSource(Source.DR_ADMIN);
            List<RoleQueryRes> roleList = queryRoleList(userRoleQueryReq);
            userPageQueryRes.setRoleList(roleList);

            pageResultSet.addRow(userPageQueryRes);
        });

        return pageResultSet;
    }

    private void initQueryReq(UserQueryReq userQueryReq) {
        if (CodeHelperUtil.isEmpty(userQueryReq.getPageNo())){
            userQueryReq.setPageNo(1);
        }

        if (CodeHelperUtil.isEmpty(userQueryReq.getPageSize())){
            userQueryReq.setPageSize(10);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateRoles(UserRoleSaveOrUpdateReq req) {
        //先删后增
        userRoleService.deleteByUserId(req.getUserId());
        userRoleService.saveUserRole(req);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(UserSaveReq userSaveReq) {
        //保存系统用户
        Integer userId = userService.saveUser(userSaveReq);
        //更新用户权限
        UserRoleSaveOrUpdateReq userRoleSaveReq = new UserRoleSaveOrUpdateReq();
        userRoleSaveReq.setUserId(userId);
        userRoleSaveReq.setRoleIds(userSaveReq.getRoleIds());
        userRoleSaveReq.setSource(Source.DR_ADMIN);
        saveOrUpdateRoles(userRoleSaveReq);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserUpdateReq userUpdateReq) {
        //保存系统用户
        userService.updateUser(userUpdateReq);
        //更新用户权限
        UserRoleSaveOrUpdateReq userRoleSaveReq = new UserRoleSaveOrUpdateReq();
        userRoleSaveReq.setUserId(userUpdateReq.getId());
        userRoleSaveReq.setRoleIds(userUpdateReq.getRoleIds());
        userRoleSaveReq.setSource(Source.DR_ADMIN);
        saveOrUpdateRoles(userRoleSaveReq);
    }

    @Override
    public Collection queryPermissions(Integer userId, Source source, Integer parentId) {
        if (source == Source.USER_CENTER) {
            //设置permissions
            CategoryQueryReq categoryQueryReq = new CategoryQueryReq();
            categoryQueryReq.setUserId(userId);
            categoryQueryReq.setParentId(parentId);
            return queryCategoryList(categoryQueryReq);
        }
        return null;
    }


}
