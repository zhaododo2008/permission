package com.codeshare.permission.category.dao;

import com.codeshare.permission.category.po.Category;
import com.codeshare.permission.category.req.CategoryQueryReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICategoryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> queryList(@Param("req") CategoryQueryReq req);

}