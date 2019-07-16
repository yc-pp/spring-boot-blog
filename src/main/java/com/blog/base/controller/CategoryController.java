package com.blog.base.controller;

import com.blog.base.entity.Category;
import com.blog.base.service.CategoryService;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;
import com.blog.base.util.Result;
import com.blog.base.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String categoryPage() {
        return "admin/category";
    }
    @RequestMapping("category/list")
    @ResponseBody
    public BootStrapTableList toIndex(@RequestParam Map<String,Object> queryParams){
        PageQueryUtil pageUtil = new PageQueryUtil(queryParams);
        return categoryService.getCategoryPage(pageUtil);
    }
    @RequestMapping("category/save")
    @ResponseBody
    public Result saveCategory(@RequestParam("categoryTitle") String categoryTitle,
                               @RequestParam("categoryDescription") String categoryDescription,
                               @RequestParam("categoryURI") String categoryURI){
        if (StringUtils.isEmpty(categoryTitle) || StringUtils.isEmpty(categoryDescription) || StringUtils.isEmpty(categoryURI) ) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        Category category=new Category();
        category.setCategorytitle(categoryTitle);
        category.setCategorydescription(categoryDescription);
        category.setCategoryuri(categoryURI);
        category.setCreatedate(new Date());
        if(categoryService.saveCategory(category)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("分类添加失败！");
        }
    }
    @RequestMapping("category/del")
    @ResponseBody
    public Result delCategory(@RequestParam("oid") Long oid){
        if(categoryService.delCategory(oid)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("分类删除失败！");
        }
    }
    @RequestMapping("category/detail")
    @ResponseBody
    public Result queryCategoryDetail(@RequestParam("oid") Long oid){
        Category category=categoryService.queryCategoryDetail(oid);
        return ResultGenerator.genSuccessResult(category);
    }
    @RequestMapping("category/update")
    @ResponseBody
    public Result updateCategory(@RequestParam("categoryOid") Long categoryOid,
                             @RequestParam("categoryTitle") String categoryTitle,
                             @RequestParam("categoryDescription") String categoryDescription,
                             @RequestParam("categoryURI") String categoryURI){
        if (StringUtils.isEmpty(categoryOid) ||StringUtils.isEmpty(categoryTitle) || StringUtils.isEmpty(categoryDescription) || StringUtils.isEmpty(categoryURI)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        Category category=new Category();
        category.setOid(categoryOid);
        category.setCategorytitle(categoryTitle);
        category.setCategorydescription(categoryDescription);
        category.setCategoryuri(categoryURI);
        if(categoryService.updateCategory(category)){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("分类修改失败！");
        }
    }
}
