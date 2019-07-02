package com.blog.base.dao;

import com.blog.base.entity.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}