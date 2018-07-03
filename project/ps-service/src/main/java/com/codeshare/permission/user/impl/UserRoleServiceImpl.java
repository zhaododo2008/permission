package com.codeshare.permission.user.impl;

import com.codeshare.common.ModelMapperUtil;
import com.codeshare.permission.common.ResponseConstant;
import com.codeshare.permission.common.exception.BusinessException;
import com.codeshare.permission.user.dao.UserRoleDao;
import com.codeshare.permission.user.dto.UserRoleQueryReq;
import com.codeshare.permission.user.dto.UserRoleQueryRes;
import com.codeshare.permission.user.dto.UserRoleSaveReq;
import com.codeshare.permission.user.po.UserRole;
import com.codeshare.permission.user.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 用户角色服务
 *
 * @author cjbi
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public List<UserRoleQueryRes> queryList(UserRoleQueryReq userRoleQuery) {
        List<UserRole> userRole = userRoleDao.selectList(userRoleQuery);
        if (userRole != null) {
            return Collections.EMPTY_LIST;
        }
        return ModelMapperUtil.strictMapList(userRole, UserRoleQueryRes.class);
    }

    @Override
    public UserRoleQueryRes queryOne(UserRoleQueryReq userRoleQuery) {
        UserRole userRole = userRoleDao.selectOne(userRoleQuery);
        if (userRole == null) {
            return null;
        }
        return ModelMapperUtil.strictMap(userRole, UserRoleQueryRes.class);
    }

    @Override
    public void deleteByUserId(Integer userId) {
        UserRoleQueryReq userRoleQueryReq = new UserRoleQueryReq();
        userRoleQueryReq.setUserId(userId);
        Optional.ofNullable(userRoleDao.selectOne(userRoleQueryReq)).ifPresent(userRole -> userRoleDao.deleteByPrimaryKey(userRole.getId()));
    }

    @Override
    public void saveUserRole(UserRoleSaveReq userRoleSaveReq) {
        UserRole userRole = ModelMapperUtil.strictMap(userRoleSaveReq, UserRole.class);
        int rows = userRoleDao.insertSelective(userRole);
        if (rows == 0) {
            throw new BusinessException(ResponseConstant.DB_INSERT_ERROR,ResponseConstant.DB_INSERT_ERROR_MSG);
        }
    }

}
