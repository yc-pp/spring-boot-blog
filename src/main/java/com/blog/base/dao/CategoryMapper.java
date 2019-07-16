package com.blog.base.dao;

import com.blog.base.entity.Category;
import com.blog.base.util.PageQueryUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> findCategoryList(PageQueryUtil pageUtil);

    int getTotalCategorys(PageQueryUtil pageUtil);
}