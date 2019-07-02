package com.blog.base.dao;

import com.blog.base.entity.Tag;
import com.blog.base.util.PageQueryUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TagMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    Tag selectByTagTitle(String tagTitle);

    List<Tag> findTagList(PageQueryUtil pageUtil);

    int getTotalTags(PageQueryUtil pageUtil);
}