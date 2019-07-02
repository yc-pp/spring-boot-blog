package com.blog.base.dao;

import com.blog.base.entity.ArchivedateArticle;

public interface ArchivedateArticleMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(ArchivedateArticle record);

    int insertSelective(ArchivedateArticle record);

    ArchivedateArticle selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(ArchivedateArticle record);

    int updateByPrimaryKey(ArchivedateArticle record);
}