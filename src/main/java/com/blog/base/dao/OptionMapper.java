package com.blog.base.dao;

import com.blog.base.entity.Option;

public interface OptionMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Option record);

    int insertSelective(Option record);

    Option selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKey(Option record);
}