package com.blog.base.controller;

import com.blog.base.entity.Article;
import com.blog.base.service.ArticleService;
import com.blog.base.service.CategoryService;
import com.blog.base.service.TagService;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;
import com.blog.base.util.Result;
import com.blog.base.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/article")
    public String articlePage() {
        return "admin/article";
    }
    @RequestMapping("article/list")
    @ResponseBody
    public BootStrapTableList toIndex(@RequestParam Map<String,Object> queryParams){
        PageQueryUtil pageUtil = new PageQueryUtil(queryParams);
        return articleService.getArticlePage(pageUtil);
    }
    @GetMapping("/article/edit")
    public String editArticle(HttpServletRequest request) {
        request.setAttribute("tags", tagService.findAllTag(0L));
        request.setAttribute("categories", categoryService.findAllCategory());
        return "admin/edit";
    }
    @GetMapping("/article/edit/{oid}")
    public String editArticle(HttpServletRequest request, @PathVariable("oid") Long oid) {
        Article article = articleService.queryArticleDetail(oid);
        if (article == null) {
            return "error/error_400";
        }
        request.setAttribute("article", article);
        request.setAttribute("tags", tagService.findAllTag(oid));
        request.setAttribute("categories", categoryService.findAllCategory());
        return "admin/edit";
    }
    @RequestMapping("article/save")
    @ResponseBody
    public Result saveArticle(HttpServletRequest request,@RequestParam("articleTitle") String articleTitle,
                              @RequestParam("articleContent") String articleContent,
                              @RequestParam("articleCategoryId") Long articleCategoryId,
                              @RequestParam("articleCommentable") Byte articleCommentable,
                              @RequestParam("articleStatus") Byte articleStatus,
                              @RequestParam("articleTag") String articleTag
                              ){
        if (StringUtils.isEmpty(articleTitle) || StringUtils.isEmpty(articleContent) || StringUtils.isEmpty(articleCategoryId)
                || StringUtils.isEmpty(articleCommentable)|| StringUtils.isEmpty(articleStatus)|| StringUtils.isEmpty(articleTag)
        ) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        Article article=new Article();
        article.setArticletitle(articleTitle);
        article.setArticlecommentable(articleCommentable);
        article.setArticlecontent(articleContent);
        article.setArticlecategoryid(articleCategoryId);
        article.setArticlestatus(articleStatus);
        HttpSession session=request.getSession();
        article.setArticleauthorid((Long)session.getAttribute("loginId"));
        article.setArticlecreated(new Date());
        article.setArticletags(articleTag);
        if(articleService.saveArticle(article)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("文章保存失败！");
        }
    }
    @RequestMapping("article/update")
    @ResponseBody
    public Result updArticle(HttpServletRequest request,
                             @RequestParam("articleId") Long oid,
                             @RequestParam("articleTitle") String articleTitle,
                             @RequestParam("articleContent") String articleContent,
                             @RequestParam("articleCategoryId") Long articleCategoryId,
                             @RequestParam("articleCommentable") Byte articleCommentable,
                             @RequestParam("articleStatus") Byte articleStatus,
                             @RequestParam("articleTag") String articleTag){
        if (StringUtils.isEmpty(oid) ||StringUtils.isEmpty(articleTitle) || StringUtils.isEmpty(articleContent) || StringUtils.isEmpty(articleCategoryId)
                || StringUtils.isEmpty(articleCommentable)|| StringUtils.isEmpty(articleStatus)|| StringUtils.isEmpty(articleTag)
        ) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        Article article=new Article();
        article.setOid(oid);
        article.setArticletitle(articleTitle);
        article.setArticlecommentable(articleCommentable);
        article.setArticlecontent(articleContent);
        article.setArticlecategoryid(articleCategoryId);
        article.setArticlestatus(articleStatus);
        HttpSession session=request.getSession();
        article.setArticleauthorid((Long)session.getAttribute("loginId"));
        article.setArticlecreated(new Date());
        article.setArticletags(articleTag);
        if(articleService.updateArticle(article)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("文章修改失败！");
        }
    }
    @RequestMapping("article/del")
    @ResponseBody
    public Result delArticle(@RequestParam("oid") Long oid){
        if(articleService.delArticle(oid)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("文章删除失败！");
        }
    }
    @RequestMapping("article/detail")
    @ResponseBody
    public Result queryArticleDetail(@RequestParam("oid") Long oid){
        Article article=articleService.queryArticleDetail(oid);
        return ResultGenerator.genSuccessResult(article);
    }
}
