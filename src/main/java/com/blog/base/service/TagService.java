package com.blog.base.service;

import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;

public interface TagService {
    BootStrapTableList getTagPage(PageQueryUtil pageUtil);

    Boolean saveTag(String tagTitle);

    Boolean delTag(Long oid);
}
