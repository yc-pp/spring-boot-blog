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
import com.blog.base.util.MarkDownUtil;
import com.blog.base.util.PageQueryUtil;
import com.blog.base.util.PageResult;
import com.blog.base.vo.BlogVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

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

    @Override
    public PageResult getBlogsForTag(String tagTitle, int page) {
        Tag tag=tagMapper.selectByTagTitle(tagTitle);
        if(tag != null){
            Map params = new HashMap();
            params.put("page", (page - 1) * 5);
            //每页8条
            params.put("limit", 5);
            params.put("tagOid", tag.getOid());
            PageQueryUtil pageQueryUtil=new PageQueryUtil(params);
            List<Article> articleList=articleMapper.getArticlesByTagTitle(pageQueryUtil);
            int total=articleMapper.getTotalArtitlesByTagTitle(pageQueryUtil);
            PageResult pageResult=new PageResult(articleList,total,pageQueryUtil.getLimit(),page);
            return pageResult;
        }
        return null;
    }

    /**
     * 查看文章详情
     * @param oid
     * @return
     */
    @Override
    public BlogVO getBlogById(Long oid) {
        Article article=articleMapper.selectByPrimaryKey(oid);
        if(article!=null){
            article.setArticleviewcount(article.getArticleviewcount()+1);
            articleMapper.updateByPrimaryKey(article);
            BlogVO blogVO=new BlogVO();
            BeanUtils.copyProperties(article,blogVO);
            blogVO.setArticlecontent(MarkDownUtil.mdToHtml(blogVO.getArticlecontent()));
            if(!StringUtils.isEmpty(article.getArticletags())){
                List<String> articleTags= Arrays.asList(article.getArticletags().split(","));
                blogVO.setArticletags(articleTags);
            }
            return blogVO;
        }
        return null;
    }

    @Override
    public PageResult getBlogsForSearch(String keyword, int page) {
        Map params = new HashMap();
        params.put("page", (page - 1) * 5);
        //每页8条
        params.put("limit", 5);
        params.put("keyword", keyword);
        params.put("blogStatus", 1);//过滤发布状态下的数据
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        List<Article> blogList = articleMapper.findArticleList(pageUtil);
        int total = articleMapper.getTotalArticles(pageUtil);
        PageResult pageResult = new PageResult(blogList, total, pageUtil.getLimit(), page);
        return pageResult;
    }
}
