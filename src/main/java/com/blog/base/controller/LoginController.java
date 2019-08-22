package com.blog.base.controller;

import com.blog.base.dao.*;
import com.blog.base.entity.User;
import com.blog.base.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/")
public class LoginController {
    @Resource
    private LoginServiceImpl loginServiceImpl;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private LinkMapper linkMapper;

    @RequestMapping("index")
    public String toIndex(HttpServletRequest request){
        request.setAttribute("articles",articleMapper.getTotalArticles(null));
        request.setAttribute("comments",commentMapper.getTotalComments(null));
        request.setAttribute("categorys",categoryMapper.getTotalCategorys(null));
        request.setAttribute("tags",tagMapper.getTotalTags(null));
        request.setAttribute("links",linkMapper.getTotalLinks(null));
        return "admin/index";
    }

    @GetMapping("login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("passWord") String passWord,
                        @RequestParam("verifyCode") String verifyCode,
                        HttpSession session,HttpServletRequest request){
        if (StringUtils.isEmpty(verifyCode)) {
            session.setAttribute("errorMsg", "验证码不能为空");
            return "admin/login";
        }
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
            session.setAttribute("errorMsg", "用户名或密码不能为空");
            return "admin/login";
        }
        String kaptchaCode = session.getAttribute("rightCode") + "";
        if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
            session.setAttribute("errorMsg", "验证码错误");
            return "admin/login";
        }
        User user=loginServiceImpl.login(userName,passWord);
        if (user != null) {
            session.setAttribute("loginNickName", user.getNickname());
            session.setAttribute("loginId", user.getOid());
            request.setAttribute("articles",articleMapper.getTotalArticles(null));
            request.setAttribute("comments",commentMapper.getTotalComments(null));
            request.setAttribute("categorys",categoryMapper.getTotalCategorys(null));
            request.setAttribute("tags",tagMapper.getTotalTags(null));
            request.setAttribute("links",linkMapper.getTotalLinks(null));
            return "admin/index";
        } else {
            session.setAttribute("errorMsg", "登陆失败");
            return "admin/login";
        }
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("loginNickName");
        request.getSession().removeAttribute("loginId");
        request.getSession().removeAttribute("errorMsg");
        return "admin/login";
    }
}

