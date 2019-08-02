package com.blog.base.service.impl;

import com.blog.base.dao.CategoryMapper;
import com.blog.base.entity.Category;
import com.blog.base.service.CategoryService;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public BootStrapTableList getCategoryPage(PageQueryUtil pageUtil) {
        List<Category> categorys = categoryMapper.findCategoryList(pageUtil);
        int total = categoryMapper.getTotalCategorys(pageUtil);
        BootStrapTableList bst=new BootStrapTableList(categorys,total);
        return bst;
    }

    @Override
    public Boolean saveCategory(Category category) {
        return categoryMapper.insertSelective(category) > 0;
    }

    @Override
    public Boolean delCategory(Long oid) {
        return categoryMapper.deleteByPrimaryKey(oid) > 0;
    }

    @Override
    public Category queryCategoryDetail(Long oid) {
        return categoryMapper.selectByPrimaryKey(oid);
    }

    @Override
    public Boolean updateCategory(Category category) {
        return categoryMapper.updateByPrimaryKeySelective(category) > 0;
    }

    @Override
    public List<Category> findAllCategory() {

        return categoryMapper.findCategoryList(null);
    }
}
