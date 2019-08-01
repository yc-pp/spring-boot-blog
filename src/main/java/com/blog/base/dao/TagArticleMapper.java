package com.blog.base.dao;

import com.blog.base.entity.TagArticle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TagArticleMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(TagArticle record);

    int insertSelective(TagArticle record);

    TagArticle selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(TagArticle record);

    int updateByPrimaryKey(TagArticle record);
    //根据标签Id查询文章-标签关联关系
    List<TagArticle> selectByTagId(Long tagId);
    //根据文章Id删除文章-标签关联数据
    boolean delTagArticleByArticleId(Long articleId);

    List<TagArticle> selectByArticleId(Long articleId);

    int batchInsertTagArticle(@Param("tagArticleList") List<TagArticle> tagArticles);
}