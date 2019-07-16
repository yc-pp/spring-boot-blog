package com.blog.base.service;

import com.blog.base.entity.Category;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;

import java.util.List;

public interface CategoryService {
    BootStrapTableList getCategoryPage(PageQueryUtil pageUtil);

    Boolean saveCategory(Category category);

    Boolean delCategory(Long oid);

    Category queryCategoryDetail(Long oid);

    Boolean updateCategory(Category category);

    List<Category> findAllCategory();
}
