package com.blog.base.dao;

import com.blog.base.entity.Link;

public interface LinkMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Link record);

    int insertSelective(Link record);

    Link selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);
}