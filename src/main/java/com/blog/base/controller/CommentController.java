package com.blog.base.controller;

import com.blog.base.service.CommentService;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;
import com.blog.base.util.Result;
import com.blog.base.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/comment")
    public String commentPage() {
        return "admin/comment";
    }
    @RequestMapping("comment/list")
    @ResponseBody
    public BootStrapTableList toIndex(@RequestParam Map<String,Object> queryParams){
        PageQueryUtil pageUtil = new PageQueryUtil(queryParams);
        return commentService.getCommentPage(pageUtil);
    }
    @RequestMapping("comment/del")
    @ResponseBody
    public Result delComment(@RequestParam("oid") Long oid){
        if(commentService.delComment(oid)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("评论删除失败！");
        }
    }
    @RequestMapping("comment/updComment")
    @ResponseBody
    public Result updComment(@RequestParam("oid") Long oid){
        if(commentService.updCommentStatus(oid)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("评论审核失败！");
        }
    }
}
