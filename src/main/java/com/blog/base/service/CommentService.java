package com.blog.base.service;

import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;

public interface CommentService {

    BootStrapTableList getCommentPage(PageQueryUtil pageUtil);

    Boolean delComment(Long oid);

    Boolean updCommentStatus(Long oid);
}
