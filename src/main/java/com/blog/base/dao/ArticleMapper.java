package com.blog.base.dao;

import com.blog.base.entity.Article;
import com.blog.base.util.PageQueryUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> findArticleList(PageQueryUtil pageUtil);

    int getTotalArticles(PageQueryUtil pageUtil);
}