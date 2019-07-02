package com.blog.base.dao;

import com.blog.base.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User login(@Param("userName") String userName, @Param("passWord") String passWord);

    int deleteByPrimaryKey(Long oid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}