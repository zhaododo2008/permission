package com.codeshare.permission.user.dao;

import com.codeshare.permission.user.dto.UserRoleQryReq;
import com.codeshare.permission.user.dto.UserRoleQueryReq;
import com.codeshare.permission.user.po.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 用户角色关联dao
 * @author cjbi
 */
public interface UserRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    List<UserRole> selectByPrimaryKeys(@Param("set") Set<Integer> ids);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<UserRole> selectList(UserRoleQryReq userRoleQuery);

    UserRole selectOne(UserRoleQryReq userRoleQuery);

}