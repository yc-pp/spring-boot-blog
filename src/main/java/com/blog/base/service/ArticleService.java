package com.blog.base.service;

import com.blog.base.entity.Article;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;
import com.blog.base.util.PageResult;
import com.blog.base.vo.BlogVO;

import java.util.List;

public interface ArticleService {
    BootStrapTableList getArticlePage(PageQueryUtil pageUtil);

    Boolean saveArticle(Article article);

    Boolean delArticle(Long oid);

    Article queryArticleDetail(Long oid);

    Boolean updateArticle(Article article);

    PageResult getBlogsForIndexPage(int page);

    List<Article> getBlogListForIndexPage(int type);

    PageResult getBlogsForCategory(String category,int page);

    PageResult getBlogsForTag(String tagTitle,int page);

    BlogVO getBlogById(Long oid);

    PageResult getBlogsForSearch(String keyword,int page);
}
