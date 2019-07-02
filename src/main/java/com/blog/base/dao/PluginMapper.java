package com.blog.base.dao;

import com.blog.base.entity.Plugin;

public interface PluginMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Plugin record);

    int insertSelective(Plugin record);

    Plugin selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Plugin record);

    int updateByPrimaryKeyWithBLOBs(Plugin record);

    int updateByPrimaryKey(Plugin record);
}