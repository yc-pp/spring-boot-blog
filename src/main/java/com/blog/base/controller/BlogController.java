package com.blog.base.controller;

import com.blog.base.entity.Link;
import com.blog.base.service.ArticleService;
import com.blog.base.service.LinkService;
import com.blog.base.service.TagService;
import com.blog.base.util.PageResult;
import com.blog.base.util.Result;
import com.blog.base.util.ResultGenerator;
import com.blog.base.vo.BlogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/blog")
public class BlogController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;
    @Autowired
    private LinkService linkService;
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
        request.setAttribute("pageUrl","page/");
        request.setAttribute("index_","index");
        request.setAttribute("blogResultPage", blogResultPage);
        request.setAttribute("name",request.getSession().getAttribute("loginNickName"));
        request.setAttribute("hotTagList",tagService.getHotTagList());
        request.setAttribute("newArticleList",articleService.getBlogListForIndexPage(1));
        request.setAttribute("hotArticleList",articleService.getBlogListForIndexPage(0));
        return "admin/blog/index";
    }

    @GetMapping({"/category/{articlecategoryid}"})
    public String category(HttpServletRequest request, @PathVariable("articlecategoryid") String articlecategoryid) {
        return category(request, articlecategoryid, 1);
    }
    @GetMapping({"/category/{articlecategoryid}/{page}"})
    public String category(HttpServletRequest request, @PathVariable("articlecategoryid") String articlecategoryid, @PathVariable("page") Integer page) {
        PageResult blogPageResult = articleService.getBlogsForCategory(articlecategoryid,page);
        request.setAttribute("index_","index");
        request.setAttribute("pageUrl","category/"+articlecategoryid+"/");
        request.setAttribute("blogResultPage", blogPageResult);
        request.setAttribute("name",request.getSession().getAttribute("loginNickName"));
        request.setAttribute("hotTagList",tagService.getHotTagList());
        request.setAttribute("newArticleList",articleService.getBlogListForIndexPage(1));
        request.setAttribute("hotArticleList",articleService.getBlogListForIndexPage(0));
        return "admin/blog/index";
    }
    @GetMapping({"/tag/{tagTitle}"})
    public String tag(HttpServletRequest request, @PathVariable("tagTitle") String tagTitle) {
        return tag(request, tagTitle, 1);
    }
    @GetMapping({"/tag/{tagTitle}/{page}"})
    public String tag(HttpServletRequest request, @PathVariable("tagTitle") String tagTitle, @PathVariable("page") Integer page) {
        PageResult blogPageResult = articleService.getBlogsForTag(tagTitle,page);
        request.setAttribute("index_","index");
        request.setAttribute("pageUrl","tag/"+tagTitle+"/");
        request.setAttribute("blogResultPage", blogPageResult);
        request.setAttribute("name",request.getSession().getAttribute("loginNickName"));
        request.setAttribute("hotTagList",tagService.getHotTagList());
        request.setAttribute("newArticleList",articleService.getBlogListForIndexPage(1));
        request.setAttribute("hotArticleList",articleService.getBlogListForIndexPage(0));
        return "admin/blog/index";
    }
    @GetMapping({"/article/{oid}"})
    public String blogDetail(HttpServletRequest request, @PathVariable("oid") Long oid) {
        BlogVO blogVO=articleService.getBlogById(oid,"0");
        request.setAttribute("index_","index");
        request.setAttribute("blogVO", blogVO);
        request.setAttribute("name",request.getSession().getAttribute("loginNickName"));
        return "admin/blog/blog-detail";
    }
    @GetMapping({"/comment/{oid}"})
    public String blogComment(HttpServletRequest request, @PathVariable("oid") Long oid) {
        BlogVO blogVO=articleService.getBlogById(oid,"1");
        request.setAttribute("blogVO", blogVO);
        request.setAttribute("index_","index");
        return "admin/blog/blog-comment";
    }
    @RequestMapping({"/article/comment"})
    @ResponseBody
    public Result blogComment(HttpServletRequest request, @RequestParam("oid") Long oid,
                              @RequestParam("comment") String comment) {

        if(articleService.updArticleCommentById((String)(request.getSession().getAttribute("loginNickName")),oid,comment)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("评论失败！");
    }
    @GetMapping({"/search/{keyword}"})
    public String search(HttpServletRequest request, @PathVariable("keyword") String keyword) {
        return search(request, keyword, 1);
    }
    @GetMapping({"/search/{keyword}/{page}"})
    public String search(HttpServletRequest request, @PathVariable("keyword") String keyword, @PathVariable("page") Integer page) {
        PageResult blogPageResult = articleService.getBlogsForSearch(keyword,page);
        request.setAttribute("index_","index");
        request.setAttribute("pageUrl","search/"+keyword+"/");
        request.setAttribute("blogResultPage", blogPageResult);
        request.setAttribute("name",request.getSession().getAttribute("loginNickName"));
        request.setAttribute("hotTagList",tagService.getHotTagList());
        request.setAttribute("newArticleList",articleService.getBlogListForIndexPage(1));
        request.setAttribute("hotArticleList",articleService.getBlogListForIndexPage(0));
        return "admin/blog/index";
    }
    @GetMapping("/link")
    public String links(HttpServletRequest request){
        List<Link> linkList = linkService.queryLinks();
        request.setAttribute("links",linkList);
        request.setAttribute("index_","link");
        return "admin/blog/blog-link";
    }
}
