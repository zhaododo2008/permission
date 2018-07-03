package com.codeshare.permission.user.dao;

import com.codeshare.permission.user.dto.UserQueryReq;
import com.codeshare.permission.user.po.User;

import java.util.List;

public interface UserDao {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectList(UserQueryReq userQueryReq);

    long countList(UserQueryReq userQueryReq);

    User selectOne(UserQueryReq userQueryReq);

    User selectLoginUser(String param);

}