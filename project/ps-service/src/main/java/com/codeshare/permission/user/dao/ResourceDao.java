package com.codeshare.permission.user.dao;


import com.codeshare.permission.user.dto.ResourceQueryReq;
import com.codeshare.permission.user.po.Resource;

import java.util.List;

public interface ResourceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<Resource> selectList(ResourceQueryReq resourceQuery);

    Resource selectOne(ResourceQueryReq resourceQuery);

}