package com.blog.base.dao;

import com.blog.base.entity.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}