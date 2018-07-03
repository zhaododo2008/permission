package com.codeshare.permission.user.impl;

import com.codeshare.common.CodeHelperUtil;
import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.common.Constants;
import com.codeshare.permission.common.PageResultSet;
import com.codeshare.permission.common.ResponseConstant;
import com.codeshare.permission.common.exception.BusinessException;
import com.codeshare.permission.user.dao.RoleDao;
import com.codeshare.permission.user.dto.RoleQueryReq;
import com.codeshare.permission.user.dto.RoleQueryRes;
import com.codeshare.permission.user.dto.RoleSaveReq;
import com.codeshare.permission.user.dto.RoleUpdateReq;
import com.codeshare.permission.user.po.Role;
import com.codeshare.permission.user.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 角色服务
 *
 * @author cjbi
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public List<RoleQueryRes> queryRoleList(Integer... roleIds) {
        List<RoleQueryRes> roleList = new ArrayList<>();
        for (Integer roleId : roleIds) {
            Role role = roleDao.selectByPrimaryKey(roleId);
            Optional.ofNullable(role).ifPresent(r -> roleList.add(ModelMapperUtil.strictMap(r, RoleQueryRes.class)));
        }
        return roleList;
    }

    @Override
    public Set<Integer> queryResources(Integer... roleIds) {
        Set<Integer> resourceIdSet = new HashSet<>();
        for (Integer roleId : roleIds) {
            Role role = roleDao.selectByPrimaryKey(roleId);
            Optional.ofNullable(role).ifPresent(r->{
                Integer[] ids = CodeHelperUtil.convertIdSplit(role.getResourceIds());
                resourceIdSet.addAll(Arrays.asList(ids));
            });
        }
        return resourceIdSet;
    }

    @Override
    public PageResultSet<RoleQueryRes> queryListByPage(RoleQueryReq roleQueryReq) {
        if (roleQueryReq.getPageNo() == null) {
            roleQueryReq.setPageNo(Constants.DEFAULT_PAGE_NUM);
        }
        if (roleQueryReq.getPageSize() == null) {
            roleQueryReq.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        }
        List<Role> list = roleDao.selectList(roleQueryReq);
        if (list == null) {
            return PageResultSet.EMPTY_RESULT;
        }
        PageResultSet<RoleQueryRes> pageResultSet = new PageResultSet<>();
        long total = roleDao.countList(roleQueryReq);
        pageResultSet.setRows(ModelMapperUtil.strictMapList(list, RoleQueryRes.class));
        pageResultSet.setTotal(total);
        return pageResultSet;
    }

    @Override
    public List<RoleQueryRes> queryList(RoleQueryReq roleQueryReq) {
        List<Role> list = roleDao.selectList(roleQueryReq);
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        return ModelMapperUtil.strictMapList(list, RoleQueryRes.class);
    }

    @Override
    public long queryTotal(RoleQueryReq roleQueryReq) {
        return roleDao.countList(roleQueryReq);
    }

    @Override
    public List<RoleQueryRes> queryAll() {
        return ModelMapperUtil.strictMapList(roleDao.selectList(null),RoleQueryRes.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRole(RoleSaveReq roleSaveReq) {
        Role role = ModelMapperUtil.strictMap(roleSaveReq, Role.class);
        int rows = roleDao.insertSelective(role);
        if (rows == 0) {
            throw new BusinessException(ResponseConstant.DB_INSERT_ERROR, ResponseConstant.DB_INSERT_ERROR_MSG);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRole(RoleUpdateReq roleUpdateReq) {
        Role role = ModelMapperUtil.strictMap(roleUpdateReq, Role.class);
        int rows = roleDao.updateByPrimaryKeySelective(role);
        if (rows == 0) {
            throw new BusinessException(ResponseConstant.DB_UPDATE_ERROR, ResponseConstant.DB_UPDATE_ERROR_MSG);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRole(Integer id) {
        int rows = roleDao.deleteByPrimaryKey(id);
        if (rows == 0) {
            throw new BusinessException(ResponseConstant.DB_DELETE_ERROR, ResponseConstant.DB_DELETE_ERROR_MSG);
        }
    }

}
