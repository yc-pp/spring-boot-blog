package com.blog.base.dao;

import com.blog.base.entity.TagArticle;

public interface TagArticleMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(TagArticle record);

    int insertSelective(TagArticle record);

    TagArticle selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(TagArticle record);

    int updateByPrimaryKey(TagArticle record);
}