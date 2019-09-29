package com.blog.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.blog.base.dao")
@SpringBootApplication
public class YcBlogApplication{
    public static void main(String[] args){
        SpringApplication.run(YcBlogApplication.class);
    }
}
