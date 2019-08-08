package com.blog.base.service.impl;

import com.blog.base.dao.ArticleMapper;
import com.blog.base.dao.CategoryMapper;
import com.blog.base.dao.TagArticleMapper;
import com.blog.base.dao.TagMapper;
import com.blog.base.entity.Article;
import com.blog.base.entity.Category;
import com.blog.base.entity.Tag;
import com.blog.base.entity.TagArticle;
import com.blog.base.service.ArticleService;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;
import com.blog.base.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagArticleMapper tagArticleMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;
    @Override
    public BootStrapTableList getArticlePage(PageQueryUtil pageUtil) {
        List<Article> articles = articleMapper.findArticleList(pageUtil);
        int total = articleMapper.getTotalArticles(pageUtil);
        BootStrapTableList bst=new BootStrapTableList(articles,total);
        return bst;
    }

    @Override
    public Boolean saveArticle(Article article) {
        Category category=categoryMapper.selectByPrimaryKey(article.getArticlecategoryid());
        if(category==null){
            article.setArticlecategoryid(0L);
            article.setArticlecategoryname("默认分类");
        }else{
            article.setArticlecategoryname(category.getCategorytitle());
            category.setCategoryorder(category.getCategoryorder()+1);
        }
        if(articleMapper.insertSelective(article) > 0){
            if(category!=null){
                categoryMapper.updateByPrimaryKeySelective(category);
            }
            List<TagArticle> list=new ArrayList<>();
            String[] tags=article.getArticletags().split(",");
            for(int i=0;i<tags.length;i++){
                Tag tag=tagMapper.selectByTagTitle(tags[i]);
                if(tag!=null){
                    TagArticle tagArticle=new TagArticle();
                    tagArticle.setArticleOid(article.getOid());
                    tagArticle.setTagOid(tag.getOid());
                    list.add(tagArticle);
                }
            }
            if(list.isEmpty()){
                TagArticle tagArticle=new TagArticle();
                tagArticle.setArticleOid(article.getOid());
                tagArticle.setTagOid(0L);
                list.add(tagArticle);
            }
            if(tagArticleMapper.batchInsertTagArticle(list) > 0){
                return true;
            }
            return false;
        }else{
            return  false;
        }
    }

    @Override
    public Boolean delArticle(Long oid) {
        if(tagArticleMapper.delTagArticleByArticleId(oid)){
            return articleMapper.deleteByPrimaryKey(oid) > 0;
        }
        return false;
    }

    @Override
    public Article queryArticleDetail(Long oid) {
        return articleMapper.selectByPrimaryKey(oid);
    }

    @Override
    public Boolean updateArticle(Article article) {
        Category category=categoryMapper.selectByPrimaryKey(article.getArticlecategoryid());
        if(category==null){
            article.setArticlecategoryid(0L);
            article.setArticlecategoryname("默认分类");
        }else{
            article.setArticlecategoryname(category.getCategorytitle());
            category.setCategoryorder(category.getCategoryorder()+1);
        }
        if(articleMapper.updateByPrimaryKeySelective(article) > 0){
            if(category!=null){
                categoryMapper.updateByPrimaryKeySelective(category);
            }
            tagArticleMapper.delTagArticleByArticleId(article.getOid());
            List<TagArticle> list=new ArrayList<>();
            String[] tags=article.getArticletags().split(",");
            for(int i=0;i<tags.length;i++){
                Tag tag=tagMapper.selectByTagTitle(tags[i]);
                if(tag!=null){
                    TagArticle tagArticle=new TagArticle();
                    tagArticle.setArticleOid(article.getOid());
                    tagArticle.setTagOid(tag.getOid());
                    list.add(tagArticle);
                }
            }
            if(list.isEmpty()){
                TagArticle tagArticle=new TagArticle();
                tagArticle.setArticleOid(article.getOid());
                tagArticle.setTagOid(0L);
                list.add(tagArticle);
            }
            if(tagArticleMapper.batchInsertTagArticle(list) > 0){
                return true;
            }
            return false;
        }else{
            return false;
        }

    }

    @Override
    public PageResult getBlogsForIndexPage(int page) {
        Map params = new HashMap();
        params.put("page", (page - 1) * 5);
        //每页8条
        params.put("limit", 5);
        params.put("blogStatus", 1);//过滤发布状态下的数据
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        List<Article> blogList = articleMapper.findArticleList(pageUtil);
        int total = articleMapper.getTotalArticles(pageUtil);
        PageResult pageResult = new PageResult(blogList, total, pageUtil.getLimit(), page);
        return pageResult;
    }

    @Override
    public List<Article> getBlogListForIndexPage(int type) {
        return articleMapper.findArticleListByType(type,10);
    }

    @Override
    public PageResult getBlogsForCategory(String category, int page) {
        Map params = new HashMap();
        params.put("page", (page - 1) * 5);
        //每页8条
        params.put("limit", 5);
        params.put("blogCategoryId", category);
        params.put("blogStatus", 1);//过滤发布状态下的数据
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        List<Article> blogList = articleMapper.findArticleList(pageUtil);
        int total = articleMapper.getTotalArticles(pageUtil);
        PageResult pageResult = new PageResult(blogList, total, pageUtil.getLimit(), page);
        return pageResult;
    }
}
