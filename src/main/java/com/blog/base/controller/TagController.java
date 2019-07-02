package com.blog.base.controller;

import com.blog.base.service.TagService;
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
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tag")
    public String tagPage() {
        return "admin/tag";
    }
    @RequestMapping("tag/list")
    @ResponseBody
    public BootStrapTableList toIndex(@RequestParam Map<String,Object> queryParams){
        PageQueryUtil pageUtil = new PageQueryUtil(queryParams);
        return tagService.getTagPage(pageUtil);
    }
    @RequestMapping("tag/save")
    @ResponseBody
    public Result saveTag(@RequestParam("tagTitle") String tagTitle){
        if(tagService.saveTag(tagTitle)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("标签名称已存在");
        }
    }
    @RequestMapping("tag/del")
    @ResponseBody
    public Result delTag(@RequestParam("oid") Long oid){
        if(tagService.delTag(oid)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("文章关联，请勿删除！");
        }
    }
}
