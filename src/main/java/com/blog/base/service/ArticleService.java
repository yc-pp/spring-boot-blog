package com.blog.base.service;

import com.blog.base.entity.Article;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;

public interface ArticleService {
    BootStrapTableList getArticlePage(PageQueryUtil pageUtil);

    Boolean saveArticle(Article article);

    Boolean delArticle(Long oid);

    Article queryArticleDetail(Long oid);

    Boolean updateArticle(Article article);

}
