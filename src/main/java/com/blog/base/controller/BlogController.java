package com.blog.base.controller;

import com.blog.base.service.ArticleService;
import com.blog.base.service.TagService;
import com.blog.base.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/blog")
public class BlogController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;
    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        return this.page(request, 1);
    }
    @GetMapping({"/page/{pageNum}"})
    public String page(HttpServletRequest request, @PathVariable("pageNum") int pageNum) {
        PageResult blogResultPage=articleService.getBlogsForIndexPage(pageNum);
        if(blogResultPage == null){
            return "admin/error/error_404.html";
        }
        request.setAttribute("blogResultPage", blogResultPage);
        request.setAttribute("name",request.getSession().getAttribute("loginNickName"));
        request.setAttribute("hotTagList",tagService.getHotTagList());
        request.setAttribute("newArticleList",articleService.getBlogListForIndexPage(1));
        return "admin/blog/index";
    }

    @GetMapping({"/category/{articlecategoryid}"})
    public String category(HttpServletRequest request, @PathVariable("articlecategoryid") String articlecategoryid) {
        return category(request, articlecategoryid, 1);
    }
    @GetMapping({"/category/{articlecategoryid}/{page}"})
    public String category(HttpServletRequest request, @PathVariable("articlecategoryid") String articlecategoryid, @PathVariable("page") Integer page) {
        PageResult blogPageResult = articleService.getBlogsForCategory(articlecategoryid,page);
        request.setAttribute("blogResultPage", blogPageResult);
        request.setAttribute("name",request.getSession().getAttribute("loginNickName"));
        request.setAttribute("hotTagList",tagService.getHotTagList());
        request.setAttribute("newArticleList",articleService.getBlogListForIndexPage(1));
        return "admin/blog/index";
    }
}
