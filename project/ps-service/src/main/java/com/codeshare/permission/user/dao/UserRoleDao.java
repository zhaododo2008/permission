package com.codeshare.permission.user.dao;

import com.codeshare.permission.user.dto.UserRoleQueryReq;
import com.codeshare.permission.user.po.UserRole;

import java.util.List;

/**
 * 用户角色关联dao
 * @author cjbi
 */
public interface UserRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<UserRole> selectList(UserRoleQueryReq userRoleQuery);

    UserRole selectOne(UserRoleQueryReq userRoleQuery);

}