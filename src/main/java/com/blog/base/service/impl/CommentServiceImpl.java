package com.blog.base.service.impl;

import com.blog.base.dao.CommentMapper;
import com.blog.base.entity.Comment;
import com.blog.base.service.CommentService;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;
import com.blog.base.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public BootStrapTableList getCommentPage(PageQueryUtil pageUtil) {
        List<CommentVO> comments = commentMapper.findCommentList(pageUtil);
        int total = commentMapper.getTotalComments(pageUtil);
        BootStrapTableList bst=new BootStrapTableList(comments,total);
        return bst;
    }

    @Override
    public Boolean delComment(Long oid) {
        return commentMapper.deleteByPrimaryKey(oid) > 0;
    }

    @Override
    public Boolean updCommentStatus(Long oid) {
        return commentMapper.updCommentStatus(oid) >= 0;
    }
}
