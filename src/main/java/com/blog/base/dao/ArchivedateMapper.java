package com.blog.base.dao;

import com.blog.base.entity.Archivedate;

public interface ArchivedateMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Archivedate record);

    int insertSelective(Archivedate record);

    Archivedate selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Archivedate record);

    int updateByPrimaryKey(Archivedate record);
}