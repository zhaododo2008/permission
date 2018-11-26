package com.codeshare.permission.user.dao;


import com.codeshare.permission.user.dto.ResourceQueryReq;
import com.codeshare.permission.user.po.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ResourceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    List<Resource> selectByPrimaryKeys(@Param("set") Set<Integer> ids);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<Resource> selectList(ResourceQueryReq resourceQuery);

    Resource selectOne(ResourceQueryReq resourceQuery);

    List<Resource> selectByParentIdsLike(String parentIds);

}