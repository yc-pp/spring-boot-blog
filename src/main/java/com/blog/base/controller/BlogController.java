package com.blog.base.controller;

import com.blog.base.service.ArticleService;
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
        return "admin/blog/index";
    }
}
