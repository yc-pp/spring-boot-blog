package com.blog.base.service;

import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;
import com.blog.base.vo.TagHotVO;
import com.blog.base.vo.TagVO;

import java.util.List;

public interface TagService {
    BootStrapTableList getTagPage(PageQueryUtil pageUtil);

    Boolean saveTag(String tagTitle);

    Boolean delTag(Long oid);

    List<TagVO> findAllTag(Long articleOid);

    List<TagHotVO> getHotTagList();
}
