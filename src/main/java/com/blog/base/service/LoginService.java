package com.blog.base.service;

import com.blog.base.entity.User;

public interface LoginService {
    User login(String userName, String passWord);
}
