package com.blog.base.dao;

import com.blog.base.entity.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}