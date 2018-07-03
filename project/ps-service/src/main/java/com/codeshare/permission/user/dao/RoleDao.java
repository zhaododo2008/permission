package com.codeshare.permission.user.dao;

import com.codeshare.permission.user.dto.RoleQueryReq;
import com.codeshare.permission.user.po.Role;

import java.util.List;
import java.util.Set;

/**
 * 角色dao
 * @author cjbi
 */
public interface RoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    List<Role> selectByPrimaryKeys(Set<Integer> ids);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectList(RoleQueryReq roleQuery);

    long countList(RoleQueryReq roleQuery);

    Role selectOne(RoleQueryReq roleQuery);

}