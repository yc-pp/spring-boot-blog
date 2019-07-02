package com.blog.base.service.impl;

import com.blog.base.dao.UserMapper;
import com.blog.base.entity.User;
import com.blog.base.service.LoginService;
import com.blog.base.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User login(String userName, String passWord) {
        String passWordMd5 = MD5Util.MD5Encode(passWord, "UTF-8");
        return userMapper.login(userName,passWordMd5);
    }
}
