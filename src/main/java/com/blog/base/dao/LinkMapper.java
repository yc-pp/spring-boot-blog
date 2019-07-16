package com.blog.base.dao;

import com.blog.base.entity.Link;
import com.blog.base.util.PageQueryUtil;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface LinkMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Link record);

    int insertSelective(Link record);

    Link selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);

    List<Link> findLinkList(PageQueryUtil pageUtil);

    int getTotalLinks(PageQueryUtil pageUtil);
}