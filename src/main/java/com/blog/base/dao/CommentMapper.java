package com.blog.base.dao;

import com.blog.base.entity.Comment;
import com.blog.base.util.PageQueryUtil;
import com.blog.base.vo.CommentVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<CommentVO> findCommentList(PageQueryUtil pageUtil);

    int getTotalComments(PageQueryUtil pageUtil);

    int updCommentStatus(Long oid);

    List<Comment> getCommentByBlogId(Long blogId);
}